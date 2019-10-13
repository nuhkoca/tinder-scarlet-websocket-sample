package com.github.nuhkoca.domain

import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    internal abstract fun provideCoinbaseRepository(coinbaseRepositoryImpl: CoinbaseRepositoryImpl):
            CoinbaseRepository
}
