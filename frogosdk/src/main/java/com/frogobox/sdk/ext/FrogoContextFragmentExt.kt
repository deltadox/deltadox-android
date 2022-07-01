package com.frogobox.sdk.ext

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson


/*
 * Created by faisalamir on 07/04/22
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

private const val TAG = "FrogoContextFragmentExt"

fun <Model> Fragment.newInstanceExt(argsKey: String, data: Model) {
    val argsData = Gson().toJson(data)
    val bundleArgs = Bundle().apply {
        putString(argsKey, argsData)
    }
    this.arguments = bundleArgs
}

inline fun <reified Model> Fragment.getInstanceExt(argsKey: String): Model {
    val argsData = this.arguments?.getString(argsKey)
    return Gson().fromJson(argsData, Model::class.java)
}

// -------------------------------------------------------------------------------------------------

fun <Model> Fragment.singleNewInstance(argsKey: String, data: Model) {
    val argsData = Gson().toJson(data)
    val bundleArgs = Bundle().apply {
        putString(argsKey, argsData)
    }
    this.arguments = bundleArgs
}

inline fun <reified Model> Fragment.singleGetInstance(argsKey: String): Model {
    val argsData = this.arguments?.getString(argsKey)
    return Gson().fromJson(argsData, Model::class.java)
}