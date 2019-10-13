package com.github.nuhkoca.domain

import com.github.nuhkoca.data.DataSource
import com.github.nuhkoca.data.Subscribe
import com.github.nuhkoca.data.Ticker
import com.github.nuhkoca.data.qualifier.Remote
import com.tinder.scarlet.websocket.WebSocketEvent
import io.reactivex.Flowable
import javax.inject.Inject

class CoinbaseRepositoryImpl @Inject constructor(
    @Remote private val remoteDataSource: DataSource
) : CoinbaseRepository {

    override fun sendSubscribe(subscribe: Subscribe) = remoteDataSource.sendSubscribe(subscribe)

    override fun observeTicker(): Flowable<Ticker> = remoteDataSource.observeTicker()

    override fun observeWebSocketEvent(): Flowable<WebSocketEvent> =
        remoteDataSource.observeWebSocketEvent()
            .filter { it is WebSocketEvent.OnConnectionOpened }
}
