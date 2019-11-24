/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：StateLayout
 * Author：Drake
 * Date：9/11/19 5:30 PM
 */

@file:Suppress("unused")

package com.drake.statelayout

import android.content.Context
import android.net.ConnectivityManager
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.collection.ArrayMap
import com.drake.statelayout.StateConfig.errorLayout

/**
 * 简单配置缺省页
 *
 * 全局配置
 * 单例配置
 * 支持Java或者XML实现
 * 无网络情况下showLoading显示错误布局, 有网则显示加载中布局
 */
class StateLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {

    private var contentId: Int = -2
    private val contentViews = ArrayMap<Int, View>()
    private var retryIds: List<Int>? = null

    // <editor-fold desc="设置缺省页">

    @LayoutRes
    var errorLayout: Int = NO_ID
        set(value) {
            if (field != value) {
                remove(field)
                field = value
            }
        }

    @LayoutRes
    var emptyLayout: Int = NO_ID
        set(value) {
            if (field != value) {
                remove(field)
                field = value
            }
        }

    @LayoutRes
    var loadingLayout: Int = NO_ID
        set(value) {
            if (field != value) {
                remove(field)
                field = value
            }
        }

    // </editor-fold>

    private var onEmpty: (View.(StateLayout) -> Unit)? = null
    private var onError: (View.(StateLayout) -> Unit)? = null
    private var onLoading: (View.(StateLayout) -> Unit)? = null
    private var onRefresh: (StateLayout.(View) -> Unit)? = null

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.StateLayout)
        try {
            emptyLayout = attributes.getResourceId(R.styleable.StateLayout_empty_layout, NO_ID)
            errorLayout = attributes.getResourceId(R.styleable.StateLayout_error_layout, NO_ID)
            loadingLayout = attributes.getResourceId(R.styleable.StateLayout_loading_layout, NO_ID)
        } finally {
            attributes.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (childCount > 1 || childCount == 0) {
            throw UnsupportedOperationException("StateLayout只能包含一个子视图")
        }
        if (contentViews.size == 0) {
            val view = getChildAt(0)
            setContentView(view)
        }
    }

    // <editor-fold desc="生命周期">

    /**
     * 当空缺省页显示时
     * @see showEmpty
     * @see StateConfig.onEmpty
     */
    fun onEmpty(block: View.(StateLayout) -> Unit) {
        onEmpty = block
    }

    /**
     * 当加载中缺省页显示时
     * @see showLoading
     * @see StateConfig.onLoading
     */
    fun onLoading(block: View.(StateLayout) -> Unit) {
        onLoading = block
    }

    /**
     * 当错误缺省页显示时
     * @see showError
     * @see StateConfig.onError
     */
    fun onError(block: View.(StateLayout) -> Unit) {
        onError = block
    }

    /**
     * 当[showLoading]时会回调该函数参数, 一般将网络请求等异步操作放入其中
     */
    fun onRefresh(block: StateLayout.(loading: View) -> Unit) {
        onRefresh = block
    }

    // </editor-fold>


    // <editor-fold desc="显示缺省页">


    /**
     * 有网则显示加载中, 无网络直接显示错误
     */
    fun showLoading() {
        if (context.isNetConnected()) {
            if (loadingLayout == NO_ID) {
                loadingLayout = StateConfig.loadingLayout
            }
            if (loadingLayout != NO_ID) {
                show(loadingLayout)
            }
        } else {
            showError()
        }
    }

    fun showEmpty() {
        if (emptyLayout == NO_ID) {
            emptyLayout = StateConfig.emptyLayout
        }
        if (emptyLayout != NO_ID) {
            show(emptyLayout)
        }
    }

    fun showError() {
        if (errorLayout == NO_ID) {
            errorLayout = StateConfig.errorLayout
        }
        if (errorLayout != NO_ID) {
            show(errorLayout)
        }
    }

    fun showContent() {
        show(contentId)
    }

    // </editor-fold>

    /**
     * 设置[errorLayout]中的视图点击后会执行[StateLayout.showLoading]
     * 并且500ms内防重复点击
     */
    fun setRetryIds(@IdRes vararg ids: Int) {
        retryIds = ids.toList()
    }

    /**
     * 显示视图
     */
    private fun show(layoutId: Int) {

        runMain {
            for (view in contentViews.values) {
                view.visibility = View.GONE
            }

            try {
                val view = getView(layoutId)
                view.visibility = View.VISIBLE
                when (layoutId) {
                    emptyLayout -> {
                        if (onEmpty == null) {
                            StateConfig.onEmpty?.let {
                                onEmpty = it
                            }
                        }
                        onEmpty?.invoke(view, this)
                    }
                    errorLayout -> {

                        if (retryIds == null) {
                            retryIds = StateConfig.retryIds
                        }

                        retryIds?.forEach {
                            view.findViewById<View>(it).throttleClick { showLoading() }
                        }

                        if (onError == null) {
                            StateConfig.onError?.let {
                                onError = it
                            }
                        }

                        onError?.invoke(view, this)
                    }
                    loadingLayout -> {
                        if (onLoading == null) {
                            StateConfig.onLoading?.let {
                                onLoading = it
                            }
                        }
                        onLoading?.invoke(view, this)
                        onRefresh?.invoke(this, view)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun remove(layoutId: Int?) {
        if (contentViews.containsKey(layoutId)) {
            val stateView = contentViews.remove(layoutId)
            removeView(stateView)
        }
    }

    @Throws(NullPointerException::class)
    private fun getView(@LayoutRes layoutId: Int): View {
        if (contentViews.containsKey(layoutId)) {
            return contentViews[layoutId]!!
        }
        val view = LayoutInflater.from(context).inflate(layoutId, this, false)
        addView(view)

        contentViews[layoutId] = view
        return view
    }


    /**
     * 标记视图为内容布局, 用于扩展替换内容. 一般情况不需要使用
     */
    fun setContentView(view: View) {
        contentViews[contentId] = view
    }

    /**
     * 判断是否有网络连接
     */
    private fun Context?.isNetConnected(): Boolean {
        if (this != null) {
            val mConnectivityManager = getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val mNetworkInfo = mConnectivityManager.activeNetworkInfo
            if (mNetworkInfo != null) {
                @Suppress("DEPRECATION")
                return mNetworkInfo.isAvailable
            }
        }
        return false
    }

    private fun runMain(block: () -> Unit) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            block()
        } else {
            Handler(Looper.getMainLooper()).post { block() }
        }
    }
}

