package com.github.nuhkoca.kotlinscarletwebsocket.di.component

import android.app.Application
import com.github.nuhkoca.core.CoreModule
import com.github.nuhkoca.data.DataModule
import com.github.nuhkoca.domain.DomainModule
import com.github.nuhkoca.kotlinscarletwebsocket.CoinbaseApp
import com.github.nuhkoca.kotlinscarletwebsocket.di.module.ActivityBuilder
import com.github.nuhkoca.kotlinscarletwebsocket.vm.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        CoreModule::class,
        DomainModule::class,
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<CoinbaseApp> {

    override fun inject(instance: CoinbaseApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
