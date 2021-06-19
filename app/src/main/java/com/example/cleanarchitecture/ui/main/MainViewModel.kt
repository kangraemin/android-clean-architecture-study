package com.example.cleanarchitecture.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.BaseViewModel
import com.example.cleanarchitecture.data.quote.QuoteItem
import com.example.cleanarchitecture.data.quote.QuoteRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class MainViewModel(
    quoteRepository: QuoteRepository
) : BaseViewModel() {

    private val _randomQuoteItem: MutableLiveData<QuoteItem> = MutableLiveData()
    val randomQuoteItem: LiveData<QuoteItem> = _randomQuoteItem

    private val refreshSubject = PublishSubject.create<Unit>()
    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    init {
        val getRandomQuote = quoteRepository
            .getRandomQuote()
            .map { ResponseToGetRandomQuote(randomQuote = it) }
            .onErrorReturn { ResponseToGetRandomQuote(throwable = it) }

        val getAllDataInMain = Single
            .zip(
                getRandomQuote,
                Single.just(Unit),
                BiFunction { t1: ResponseToGetRandomQuote, t2: Unit -> return@BiFunction Pair(t1, t2) }
            )

        val refreshing = refreshSubject
            .doOnNext { _isRefreshing.value = true }
            .startWith(Unit)
            .flatMapSingle { getAllDataInMain }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { _isRefreshing.value = false }
            .materialize()

        refreshing
            .filter { it.isOnNext }
            .map { it.value }
            .map { it.first }
            .subscribe({
                if (it.throwable != null) {
                    it.throwable.printStackTrace()
                } else {
                    it.randomQuote?.let {
                        _randomQuoteItem.value = it
                    }
                }
            }, { it.printStackTrace() })
            .addTo(compositeDisposable)
    }

    fun onRefresh() {
        refreshSubject.onNext(Unit)
    }

    private data class ResponseToGetRandomQuote(
        val randomQuote: QuoteItem? = null,
        val throwable: Throwable? = null
    )
}