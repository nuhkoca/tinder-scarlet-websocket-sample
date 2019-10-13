package com.github.nuhkoca.kotlinscarletwebsocket.ui

import com.github.ajalt.timberkt.Timber.d
import com.github.nuhkoca.core.BaseActivity
import com.github.nuhkoca.core.util.ext.observeWith
import com.github.nuhkoca.kotlinscarletwebsocket.R
import kotlinx.android.synthetic.main.activity_main.tvResult

class MainActivity : BaseActivity<MainViewModel>() {

    override val layoutId = R.layout.activity_main

    override fun getViewModelClass() = MainViewModel::class.java

    override fun initView() {
        // no-op
    }

    override fun observeViewModel() = with(viewModel) {
        tickerLiveData.observeWith(this@MainActivity) {
            d { "Bitcoin price is ${it.price} at ${it.time}" }
            tvResult.text = "Bitcoin price is ${it.price} at ${it.time}"
        }
        startEvent()
    }
}
