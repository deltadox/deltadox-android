package com.frogobox.admob.ui

import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.view.FrogoActivity

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


abstract class FrogoAdmobActivity : FrogoActivity(),
    AdmobDelegates by AdmobDelegatesImpl() {

    companion object {
        val TAG: String = FrogoAdmobActivity::class.java.simpleName
    }
    override fun setupMonetized() {
        super.setupMonetized()
        setupAdmobDelegates(this)
        setupAdmobApp()
    }

}