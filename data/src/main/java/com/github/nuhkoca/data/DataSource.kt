package com.github.nuhkoca.data

import com.tinder.scarlet.websocket.WebSocketEvent
import io.reactivex.Flowable

interface DataSource {
    fun sendSubscribe(subscribe: Subscribe)
    fun observeTicker(): Flowable<Ticker>
    fun observeWebSocketEvent(): Flowable<WebSocketEvent>
}
