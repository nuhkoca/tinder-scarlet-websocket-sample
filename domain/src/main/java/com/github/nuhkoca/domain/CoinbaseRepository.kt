package com.github.nuhkoca.domain

import com.github.nuhkoca.data.Subscribe
import com.github.nuhkoca.data.Ticker
import com.tinder.scarlet.websocket.WebSocketEvent
import io.reactivex.Flowable

interface CoinbaseRepository {
    fun sendSubscribe(subscribe: Subscribe)
    fun observeTicker(): Flowable<Ticker>
    fun observeWebSocketEvent(): Flowable<WebSocketEvent>
}
