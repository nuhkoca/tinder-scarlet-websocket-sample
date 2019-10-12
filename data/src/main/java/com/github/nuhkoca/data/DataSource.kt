package com.github.nuhkoca.data

import io.reactivex.Flowable

interface DataSource {
    fun sendSubscribe(subscribe: Subscribe)
    fun observeTicker(): Flowable<Ticker>
    fun observeSocketEvent()
}
