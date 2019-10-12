package com.github.nuhkoca.data

import android.app.Application
import com.github.nuhkoca.data.DataModule.StaticDataModule
import com.github.nuhkoca.data.qualifier.Remote
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.ShutdownReason
import com.tinder.scarlet.websocket.okhttp.OkHttpWebSocket
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module(includes = [StaticDataModule::class])
abstract class DataModule {

    @Binds
    @Remote
    abstract fun provideRemoteDataSource(remoteDataSource: CoinbaseRemoteDataSource): DataSource

    @Module
    object StaticDataModule {

        private const val DEFAULT_TIMEOUT_IN_SEC = 10L

        @Provides
        @Singleton
        @JvmStatic
        fun provideLifecycle(application: Application) =
            AndroidLifecycle.ofApplicationForeground(application)

        @Provides
        @Singleton
        @JvmStatic
        fun provideScarletInstance(
            protocol: OkHttpWebSocket,
            configuration: Scarlet.Configuration
        ) =
            Scarlet(protocol, configuration)

        @Provides
        @Singleton
        @JvmStatic
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT_IN_SEC, SECONDS)
            .readTimeout(DEFAULT_TIMEOUT_IN_SEC, SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT_IN_SEC, SECONDS)
            .build()

        @Provides
        @Singleton
        @JvmStatic
        fun provideScarletConfiguration(lifecycle: Lifecycle) = Scarlet.Configuration(
            lifecycle = lifecycle,
            messageAdapterFactories = listOf(MoshiMessageAdapter.Factory()),
            streamAdapterFactories = listOf(RxJava2StreamAdapterFactory())
        )

        @Provides
        @Singleton
        @JvmStatic
        fun provideScarletProtocol(okHttpClient: OkHttpClient) = OkHttpWebSocket(
            okHttpClient,
            OkHttpWebSocket.SimpleRequestFactory(
                { Request.Builder().url(BuildConfig.baseUrl).build() },
                { ShutdownReason.GRACEFUL }
            )
        )

        @Provides
        @Singleton
        @JvmStatic
        fun provideCoinbaseService(scarlet: Scarlet): CoinbaseService = scarlet.create()
    }
}
