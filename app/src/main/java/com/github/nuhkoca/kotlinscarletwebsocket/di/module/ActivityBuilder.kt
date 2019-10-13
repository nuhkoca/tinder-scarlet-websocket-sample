package com.github.nuhkoca.kotlinscarletwebsocket.di.module

import com.github.nuhkoca.kotlinscarletwebsocket.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun provideMainActivity(): MainActivity
}
