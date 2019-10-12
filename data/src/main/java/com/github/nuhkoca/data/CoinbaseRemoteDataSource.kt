package com.github.nuhkoca.data

import io.reactivex.Flowable
import javax.inject.Inject

class CoinbaseRemoteDataSource @Inject constructor(
    private val coinbaseService: CoinbaseService
) : DataSource {

    override fun sendSubscribe(subscribe: Subscribe) = coinbaseService.sendSubscribe(subscribe)

    override fun observeTicker(): Flowable<Ticker> = coinbaseService.observeTicker()

    override fun observeSocketEvent() {
        coinbaseService.observeOnConnectionOpenedEvent()
    }
}
