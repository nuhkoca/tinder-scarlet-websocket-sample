package com.github.nuhkoca.core

import com.github.nuhkoca.core.util.executors.CoinbaseComputationThread
import com.github.nuhkoca.core.util.executors.CoinbaseExecutionThread
import com.github.nuhkoca.core.util.executors.CoinbasePostExecutionThread
import com.github.nuhkoca.core.util.executors.ComputationThread
import com.github.nuhkoca.core.util.executors.ExecutionThread
import com.github.nuhkoca.core.util.executors.PostExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class CoreModule {

    @Binds
    internal abstract fun provideExecutionThread(executionThread: CoinbaseExecutionThread):
            ExecutionThread

    @Binds
    internal abstract fun providePostExecutionThread(postExecutionThread: CoinbasePostExecutionThread):
            PostExecutionThread

    @Binds
    internal abstract fun provideComputationThread(computationThread: CoinbaseComputationThread):
            ComputationThread
}
