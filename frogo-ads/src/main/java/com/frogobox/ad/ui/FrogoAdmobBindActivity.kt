package com.frogobox.ad.ui

import androidx.viewbinding.ViewBinding
import com.frogobox.ad.delegate.AdmobDelegates
import com.frogobox.ad.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.view.FrogoBindActivity


/**
 * Created by faisalamir on 01/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */


abstract class FrogoAdmobBindActivity<VB : ViewBinding> : FrogoBindActivity<VB>(),
    AdmobDelegates by AdmobDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdmobBindActivity::class.java.simpleName
    }

    override fun setupMonetized() {
        super.setupMonetized()
        setupAdmobDelegates(this)
        setupAdmobApp()
    }

}