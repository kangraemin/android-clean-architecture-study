package com.example.cleanarchitecture.presentationlayer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domainlayer.requestmodel.EntireDataRequestModel
import com.example.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.domainlayer.requestmodel.dataprovidor.QuoteRequestModel
import com.example.domainlayer.responsemodel.EntireDataResponseModel
import com.example.domainlayer.usecase.user.UserUseCaseInteractor
import com.example.cleanarchitecture.presentationlayer.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class MainViewModel(
    userUseCaseInteractor: UserUseCaseInteractor
) : BaseViewModel() {

    private val _randomQuoteItem: MutableLiveData<String> = MutableLiveData()
    val randomQuoteItem: LiveData<String> = _randomQuoteItem

    private val _randomCatImageItem: MutableLiveData<String> = MutableLiveData()
    val randomCatImageItem: LiveData<String> = _randomCatImageItem

    private val refreshSubject = PublishSubject.create<Unit>()
    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    init {
        val refreshing = refreshSubject
            .doOnNext { _isRefreshing.value = true }
            .startWith(Unit)
            .flatMapSingle {
                userUseCaseInteractor
                    .getEntireData(
                        EntireDataRequestModel(
                            quoteRequestModel = QuoteRequestModel(Unit),
                            catImageRequestModel = CatImageRequestModel(Unit)
                        )
                    )
                    .map { ResponseToGetEntireData(it) }
                    .onErrorReturn { ResponseToGetEntireData(throwable = it) }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { _isRefreshing.value = false }

        refreshing
            .subscribe({ responseToGetEntireData ->
                if (responseToGetEntireData.throwable != null) {
                    responseToGetEntireData.throwable.printStackTrace()
                } else {
                    responseToGetEntireData.entireDataResponseModel?.let {
                        it.entireData.run {
                            _randomQuoteItem.value = first.quote
                            _randomCatImageItem.value = second.catImageUrl
                        }
                    }
                }
            }, { it.printStackTrace() })
            .addTo(compositeDisposable)
    }

    fun onRefresh() {
        refreshSubject.onNext(Unit)
    }

    private data class ResponseToGetEntireData(
        val entireDataResponseModel: EntireDataResponseModel? = null,
        val throwable: Throwable? = null
    )
}