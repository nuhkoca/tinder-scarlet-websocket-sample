package com.github.nuhkoca.data

import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface CoinbaseService {
    @Send
    fun sendSubscribe(subscribe: Subscribe)

    @Receive
    fun observeTicker(): Flowable<Ticker>

    @Receive
    fun observeOnConnectionOpenedEvent(): Flowable<WebSocketEvent>
}
