package com.github.nuhkoca.kotlinscarletwebsocket.ui

import androidx.lifecycle.ViewModel
import com.github.nuhkoca.kotlinscarletwebsocket.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel
}
