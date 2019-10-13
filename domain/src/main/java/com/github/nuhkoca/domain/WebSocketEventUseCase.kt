package com.github.nuhkoca.domain

import com.github.nuhkoca.core.UseCase.FlowableUseCase
import com.github.nuhkoca.core.UseCase.None
import com.tinder.scarlet.websocket.WebSocketEvent
import io.reactivex.Flowable
import javax.inject.Inject

class WebSocketEventUseCase @Inject constructor(
    private val coinbaseRepository: CoinbaseRepository
) : FlowableUseCase<None, WebSocketEvent> {

    override fun execute(params: None): Flowable<WebSocketEvent> {
        return coinbaseRepository.observeWebSocketEvent()
            .filter { it is WebSocketEvent.OnConnectionOpened }
    }
}
