package com.frogobox.appadmob.mvvm.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.admob.core.FrogoAdmob.loadRecyclerBannerAds
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.BuildConfig
import com.frogobox.R
import com.frogobox.appadmob.base.BaseActivity
import com.frogobox.databinding.ActivityRecyclerViewAdmobBinding
import com.frogobox.coreapi.ConsumeApiResponse
import com.frogobox.coreutil.news.NewsConstant
import com.frogobox.coreutil.news.NewsUrl
import com.frogobox.coreutil.news.response.ArticleResponse
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.google.android.gms.ads.AdView

class NewsAdsActivity : BaseActivity<ActivityRecyclerViewAdmobBinding>() {

    private val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun setupViewBinding(): ActivityRecyclerViewAdmobBinding {
        return ActivityRecyclerViewAdmobBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("RecyclerView (1)")
        setupNewsApi()
    }

    private fun setupNewsApi() {
        val consumeNewsApi =
            ConsumeNewsApi(NewsUrl.API_KEY).usingChuckInterceptor(BuildConfig.DEBUG, this)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            NewsConstant.CATEGORY_HEALTH,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : ConsumeApiResponse<ArticleResponse> {

                override fun onShowProgress() {
                    // Your Progress Show
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    // Your failed to do
                }

                override fun onFinish() {

                }

                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { arrayFrogoAdmobData.addAll(it) }
                    loadRecyclerBannerAds(
                        getString(R.string.admob_banner),
                        this@NewsAdsActivity,
                        arrayFrogoAdmobData
                    )
                    setupRecyclerView()
                }

            })
    }

    private fun setupAdapter(): NewsAdapter {
        val adapter = NewsAdapter()
        adapter.setupRequirement(
            R.layout.content_item_news,
            arrayFrogoAdmobData,
            object : FrogoRecyclerViewListener<Any> {
                override fun onItemClicked(
                    view: View,
                    data: Any,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<Any>
                ) {
                }

                override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                    return oldItem == newItem
                }

                override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                    return oldItem == newItem
                }

            })
        return adapter
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@NewsAdsActivity, LinearLayoutManager.VERTICAL, false)
            adapter = setupAdapter()
        }
    }

    override fun onResume() {
        super.onResume()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }

    }


}