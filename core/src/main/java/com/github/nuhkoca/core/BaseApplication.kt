package com.github.nuhkoca.core

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

abstract class BaseApplication : DaggerApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    abstract override fun applicationInjector(): AndroidInjector<out DaggerApplication>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
