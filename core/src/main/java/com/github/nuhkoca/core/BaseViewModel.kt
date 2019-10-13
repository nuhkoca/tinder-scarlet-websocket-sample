package com.github.nuhkoca.core

import androidx.lifecycle.ViewModel
import com.github.nuhkoca.core.util.executors.Executors
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(protected open var executors: Executors) : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}
