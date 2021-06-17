package com.example.cleanarchitecture.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.BaseViewModel
import com.example.cleanarchitecture.data.quote.QuoteItem
import com.example.cleanarchitecture.data.quote.QuoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class MainViewModel(
    quoteRepository: QuoteRepository
) : BaseViewModel() {

    private val getRandomQuoteSubject = PublishSubject.create<Unit>()
    private val _randomQuoteItem: MutableLiveData<QuoteItem> = MutableLiveData()
    val randomQuoteItem: LiveData<QuoteItem> = _randomQuoteItem

    init {
        getRandomQuoteSubject
            .startWith(Unit)
            .switchMapSingle {
                quoteRepository
                    .getRandomQuote()
                    .map { ResponseToGetRandomQuote(randomQuote = it) }
                    .onErrorReturn { ResponseToGetRandomQuote(throwable = it) }
            }
            .observeOn(AndroidSchedulers.mainThread())
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

    private data class ResponseToGetRandomQuote(
        val randomQuote: QuoteItem? = null,
        val throwable: Throwable? = null
    )
}