package com.github.nuhkoca.kotlinscarletwebsocket.di

import android.app.Application
import com.github.nuhkoca.data.DataModule
import com.github.nuhkoca.kotlinscarletwebsocket.ScarletApp
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
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<ScarletApp> {

    override fun inject(instance: ScarletApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
