package com.github.nuhkoca.kotlinscarletwebsocket

import com.github.nuhkoca.core.BaseApplication
import com.github.nuhkoca.kotlinscarletwebsocket.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class CoinbaseApp : BaseApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this).also { appComponent ->
            appComponent.inject(this)
        }
}
