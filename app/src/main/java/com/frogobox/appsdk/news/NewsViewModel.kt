package com.frogobox.appsdk.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.frogobox.appsdk.model.Article
import com.frogobox.appsdk.source.AppRepository
import com.frogobox.appsdk.util.NewsConstant
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.sdk.ext.showLogDebug
import com.frogobox.sdk.ext.showLogError
import com.frogobox.sdk.view.FrogoViewModel2


/*
 * Created by faisalamir on 08/04/22
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

class NewsViewModel(
    private val repository: AppRepository,
) : FrogoViewModel2() {

    private var _articles = MutableLiveData<List<Article>>()
    var articles: LiveData<List<Article>> = _articles

    private fun getData() {
        repository.handlingNetworkTopHeadLine(
            null,
            null,
            NewsConstant.CATEGORY_GENERAL,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : FrogoDataResponse<List<Article>> {
                override fun onFailed(statusCode: Int, errorMessage: String) {
                    showLogError(errorMessage)
                }

                override fun onFinish() {
                    showLogDebug("ON FINISH  --------> ")
                }

                override fun onHideProgress() {
                    showLogDebug("ON HIDE PROGRES --------> ")
                    _eventShowProgressState.postValue(false)
                }

                override fun onShowProgress() {
                    showLogDebug("ON SHOW PROGRES --------> ")
                    _eventShowProgressState.postValue(true)
                }

                override fun onSuccess(data: List<Article>) {
                    _articles.postValue(data)
                }
            }
        )
    }

    private fun getPref() {
        repository.getPrefString("KEY_PREF", object : FrogoDataResponse<String> {
            override fun onFailed(statusCode: Int, errorMessage: String) {}
            override fun onFinish() {}
            override fun onHideProgress() {}
            override fun onShowProgress() {}
            override fun onSuccess(data: String) {}
        })
    }

    override fun onStart() {
        super.onStart()
        getData()
        getPref()
    }

    override fun onClearDisposable() {
        super.onClearDisposable()
        repository.onClearDisposables()
    }

}