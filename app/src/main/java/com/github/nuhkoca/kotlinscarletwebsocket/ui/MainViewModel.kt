package com.github.nuhkoca.kotlinscarletwebsocket.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.w
import com.github.nuhkoca.core.BaseViewModel
import com.github.nuhkoca.core.UseCase.None
import com.github.nuhkoca.core.util.executors.Executors
import com.github.nuhkoca.core.util.ext.applySchedulers
import com.github.nuhkoca.data.Ticker
import com.github.nuhkoca.domain.ObserveTickerUseCase
import com.github.nuhkoca.domain.SendSubscribeUseCase
import com.github.nuhkoca.domain.SendSubscribeUseCase.SubscribeParams
import com.github.nuhkoca.domain.WebSocketEventUseCase
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val webSocketEventUseCase: WebSocketEventUseCase,
    private val sendSubscribeUseCase: SendSubscribeUseCase,
    private val observeTickerUseCase: ObserveTickerUseCase,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _tickerLiveData = MutableLiveData<Ticker>()
    val tickerLiveData: LiveData<Ticker> get() = _tickerLiveData

    fun startEvent() {
        webSocketEventUseCase.execute(None())
            .applySchedulers(executors)
            .subscribe({ sendSubscribeUseCase.execute(BITCOIN_TICKER_SUBSCRIBE_MESSAGE) },
                { w { it.localizedMessage?.toString().toString() } })
            .addTo(disposables)

        observeTickerUseCase.execute(None())
            .applySchedulers(executors)
            .subscribe(_tickerLiveData::setValue) {
                w { it.localizedMessage?.toString().toString() }
            }
            .addTo(disposables)
    }

    companion object {
        private val BITCOIN_TICKER_SUBSCRIBE_MESSAGE = SubscribeParams(
            productIds = listOf("BTC-USD")
        )
    }
}
