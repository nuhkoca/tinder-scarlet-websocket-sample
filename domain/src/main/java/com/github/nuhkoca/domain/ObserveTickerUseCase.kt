package com.github.nuhkoca.domain

import com.github.nuhkoca.core.UseCase.FlowableUseCase
import com.github.nuhkoca.core.UseCase.None
import com.github.nuhkoca.data.Ticker
import io.reactivex.Flowable
import javax.inject.Inject

class ObserveTickerUseCase @Inject constructor(
    private val coinbaseRepository: CoinbaseRepository
) : FlowableUseCase<None, Ticker> {

    override fun execute(params: None): Flowable<Ticker> {
        return coinbaseRepository.observeTicker()
    }
}
