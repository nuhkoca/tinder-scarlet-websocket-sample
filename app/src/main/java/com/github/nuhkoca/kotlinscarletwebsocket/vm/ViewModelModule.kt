package com.github.nuhkoca.kotlinscarletwebsocket.vm

import androidx.lifecycle.ViewModelProvider
import com.github.nuhkoca.kotlinscarletwebsocket.ui.MainViewModelModule
import dagger.Binds
import dagger.Module

@Module(includes = [MainViewModelModule::class])
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindsCoinbaseViewModelFactory(
        viewModelFactory: CoinbaseViewModelFactory
    ): ViewModelProvider.Factory
}
