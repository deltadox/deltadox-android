package com.frogobox.sdk

import android.view.View
import androidx.fragment.app.Fragment

/*
 * Created by faisalamir on 28/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoActivity {

    fun setupDetailActivity(title: String)

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun showToast(message: String)

    fun setupEmptyView(view: View, isEmpty: Boolean)

    fun setupProgressView(view: View, isProgress: Boolean)

    fun checkExtra(extraKey: String): Boolean

    fun <Model> baseFragmentNewInstance(
        fragment: FrogoFragment<*>,
        argumentKey: String,
        extraDataResult: Model
    )

    fun isNetworkConnected(): Boolean

    fun setupFullScreen()

    fun setupHideSystemUI()

    fun shareApp(packageName: String, appName: String)

    fun rateApp(packageName: String)

    fun verifySignature()

    fun readSignature()

    fun verifyInstallerId()

    fun verifyUnauthorizedApps()

    fun verifyStores()

    fun verifyDebug()

    fun verifyEmulator()

    fun showApkSignatures()

}