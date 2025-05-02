package com.frogobox.ad.ui

import androidx.viewbinding.ViewBinding
import com.frogobox.ad.delegate.UnityAdDelegates
import com.frogobox.ad.delegate.UnityAdDelegatesImpl
import com.frogobox.sdk.view.FrogoBindActivity

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 31/10/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper
 *
 */


abstract class FrogoUnityAdBindActivity<VB : ViewBinding> : FrogoBindActivity<VB>(),
    UnityAdDelegates by UnityAdDelegatesImpl() {

    companion object {
        val TAG: String = FrogoUnityAdBindActivity::class.java.simpleName
    }

    override fun setupMonetized() {
        super.setupMonetized()
        setupUnityAdDelegates(this)
    }

}