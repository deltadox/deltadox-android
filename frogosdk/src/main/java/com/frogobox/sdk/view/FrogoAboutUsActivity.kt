package com.frogobox.sdk.view

import android.os.Bundle
import com.frogobox.sdk.FrogoActivity
import com.frogobox.sdk.databinding.ActivityFrogoAboutUsBinding

class FrogoAboutUsActivity : FrogoActivity<ActivityFrogoAboutUsBinding>() {

    override fun setupViewBinding(): ActivityFrogoAboutUsBinding {
        return ActivityFrogoAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupOnCreate(savedInstanceState: Bundle?) {
        setupDetailActivity("About Frogobox")
        binding.tvCopyright.text = textCopyright
    }

}