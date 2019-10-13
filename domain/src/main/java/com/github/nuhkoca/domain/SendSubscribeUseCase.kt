package com.github.nuhkoca.domain

import com.github.nuhkoca.core.UseCase
import com.github.nuhkoca.core.UseCase.Params
import com.github.nuhkoca.data.Subscribe
import com.github.nuhkoca.domain.SendSubscribeUseCase.SubscribeParams
import javax.inject.Inject

class SendSubscribeUseCase @Inject constructor(
    private val coinbaseRepository: CoinbaseRepository
) : UseCase.RequestUseCase<SubscribeParams, Unit> {

    override fun execute(params: SubscribeParams) {
        coinbaseRepository.sendSubscribe(
            Subscribe(params.type, params.productIds, params.channels)
        )
    }

    class SubscribeParams(
        val type: String = "subscribe",
        val productIds: List<String>,
        val channels: List<String> = listOf("ticker")
    ) : Params()
}
