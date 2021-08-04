/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused", "MemberVisibilityCanBePrivate", "NAME_SHADOWING", "RedundantSetter")

package com.drake.statelayout

import android.content.Context
import android.content.res.Resources
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
import com.drake.statelayout.Status.*

/**
 * 应用全局缺省页
 *
 * 全局配置
 * 单例配置
 * 局部缺省页
 * 数据传递
 * 监听缺省页显示生命周期
 * 自定义动画
 * 布局或代码声明皆可
 * 快速配置点击重试
 * 无网络立即显示错误缺省页
 */
class StateLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val views = ArrayMap<Status, View>()
    private var refresh = true
    private var stateChanged = false
    private var trigger = false

    private var retryIds: IntArray? = null
        get() = field ?: StateConfig.retryIds
    private var onEmpty: (View.(tag: Any?) -> Unit)? = null
        get() = field ?: StateConfig.onEmpty
    private var onError: (View.(tag: Any?) -> Unit)? = null
        get() = field ?: StateConfig.onError
    private var onContent: (View.(tag: Any?) -> Unit)? = null
        get() = field ?: StateConfig.onContent
    private var onLoading: (View.(tag: Any?) -> Unit)? = null
        get() = field ?: StateConfig.onLoading
    private var onRefresh: (StateLayout.(tag: Any?) -> Unit)? = null

    /** 当前缺省页是否加载成功过, 即是否执行过[showContent] */
    var loaded = false

    /** 当前缺省页状态[Status] */
    var status = CONTENT
        private set

    // <editor-fold desc="设置缺省页">

    /** 错误页面布局 */
    @LayoutRes
    var errorLayout: Int = NO_ID
        get() = if (field == NO_ID) StateConfig.errorLayout else field
        set(value) {
            if (field != value) {
                removeStatus(ERROR)
                field = value
            }
        }

    /** 空页面布局 */
    @LayoutRes
    var emptyLayout: Int = NO_ID
        get() = if (field == NO_ID) StateConfig.emptyLayout else field
        set(value) {
            if (field != value) {
                removeStatus(EMPTY)
                field = value
            }
        }

    /** 加载中页面布局 */
    @LayoutRes
    var loadingLayout: Int = NO_ID
        get() = if (field == NO_ID) StateConfig.loadingLayout else field
        set(value) {
            if (field != value) {
                removeStatus(LOADING)
                field = value
            }
        }

    // </editor-fold>

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
            throw UnsupportedOperationException("StateLayout only have one child view")
        }
        if (views.size == 0) {
            val view = getChildAt(0)
            setContentView(view)
        }
    }

    // <editor-fold desc="监听缺省页">

    /**
     * 当空缺省页显示时回调
     * @see showEmpty
     * @see StateConfig.onEmpty
     */
    fun onEmpty(block: View.(tag: Any?) -> Unit) = apply {
        onEmpty = block
    }

    /**
     * 当错误缺省页显示时回调
     * @see showError
     * @see StateConfig.onError
     */
    fun onError(block: View.(tag: Any?) -> Unit) = apply {
        onError = block
    }

    /**
     * 当加载中缺省页显示时回调
     * @see showLoading
     * @see StateConfig.onLoading
     */
    fun onLoading(block: View.(tag: Any?) -> Unit) = apply {
        onLoading = block
    }

    /**
     * 当[showLoading]时会回调该函数参数, 一般将网络请求等异步操作放入其中
     */
    fun onRefresh(block: StateLayout.(tag: Any?) -> Unit) = apply {
        onRefresh = block
    }

    /**
     * 当[showContent]时会回调该函数参数, 一般将网络请求等异步操作放入其中
     * @see showContent
     * @see StateConfig.onContent
     */
    fun onContent(block: View.(tag: Any?) -> Unit) = apply {
        onContent = block
    }

    // </editor-fold>

    // <editor-fold desc="显示缺省页">

    /**
     * 有网则显示加载中, 无网络直接显示错误, 会触发[onLoading]的函数参数
     * @param tag 传递任意对象给[onLoading]函数
     * @param silent 仅执行[onRefresh], 不会显示加载中布局, 也不执行[onLoading]
     * @param refresh 是否回调[onRefresh]
     */
    fun showLoading(tag: Any? = null, silent: Boolean = false, refresh: Boolean = true) {
        this.refresh = refresh
        if (silent && refresh) {
            onRefresh?.invoke(this, tag)
            return
        }
        if (status == LOADING) {
            onLoading?.invoke(getStatusView(LOADING), tag)
            return
        }
        show(LOADING, tag)
    }

    /**
     * 显示空页, 会触发[onEmpty]的函数参数
     * @param tag 传递任意对象给[onEmpty]函数
     */
    fun showEmpty(tag: Any? = null) {
        show(EMPTY, tag)
    }

    /**
     * 显示错误页, 会触发[onError]的函数参数
     * @param tag 传递任意对象给[onError]函数
     */
    fun showError(tag: Any? = null) {
        show(ERROR, tag)
    }

    /**
     * 显示内容布局, 表示成功缺省页
     * @param tag 传递任意对象给[onContent]函数
     */
    fun showContent(tag: Any? = null) {
        if (trigger && stateChanged) return
        show(CONTENT, tag)
    }

    // </editor-fold>

    /**
     * 为错误页/空页中的指定Id控件设置点击事件, 点击会触发[showLoading]
     * 默认点击500ms内防抖动
     */
    fun setRetryIds(@IdRes vararg ids: Int) = apply {
        retryIds = ids
    }

    /**
     * 本函数为方便其他框架热插拔使用, 开发者一般情况不使用
     * 本函数调用两次之间显示缺省页只会有效执行一次
     */
    fun trigger(): Boolean {
        trigger = !trigger
        if (!trigger) stateChanged = false
        return trigger
    }

    /**
     * 显示视图
     */
    private fun show(status: Status, tag: Any? = null) {
        if (trigger) stateChanged = true
        this.status = status
        runMain {
            try {
                val view = showStatus(status)
                when (status) {
                    EMPTY -> {
                        retryIds?.forEach {
                            view.findViewById<View>(it)?.throttleClick {
                                showLoading()
                            }
                        }
                        onEmpty?.invoke(view, tag)
                    }
                    ERROR -> {
                        retryIds?.forEach {
                            view.findViewById<View>(it)?.throttleClick {
                                showLoading()
                            }
                        }
                        onError?.invoke(view, tag)
                    }
                    LOADING -> {
                        onLoading?.invoke(view, tag)
                        if (refresh) onRefresh?.invoke(this, tag)
                    }
                    else -> {
                        loaded = true
                        onContent?.invoke(view, tag)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showStatus(status: Status): View {
        val target = getStatusView(status)
        for (view in views.values) {
            if (target == view) {
                view.visibility = VISIBLE
            } else {
                view.visibility = GONE
            }
        }
        return target
    }

    /**
     * 删除指定的缺省页
     */
    private fun removeStatus(status: Status?) {
        views.remove(status)?.let { removeView(it) }
    }

    /**
     * 返回缺省页视图对象
     */
    @Throws(NullPointerException::class)
    private fun getStatusView(status: Status): View {
        views[status]?.let { return it }
        val layoutId = when (status) {
            EMPTY -> emptyLayout
            ERROR -> errorLayout
            LOADING -> loadingLayout
            else -> NO_ID
        }
        if (layoutId == NO_ID) {
            when (status) {
                ERROR -> throw Resources.NotFoundException("No StateLayout errorLayout is set")
                EMPTY -> throw Resources.NotFoundException("No StateLayout emptyLayout is set")
                LOADING -> throw Resources.NotFoundException("No StateLayout loadingLayout is set")
                else -> throw Resources.NotFoundException("No StateLayout contentView is set")
            }
        }
        val view = LayoutInflater.from(context).inflate(layoutId, this, false)
        addView(view)
        views[status] = view
        return view
    }

    /**
     * 标记视图为内容布局, 本函数为其他框架进行热插拔适配使用, 一般情况开发者不使用
     */
    fun setContentView(view: View) {
        views[CONTENT] = view
    }

    /**
     * 判断是否有网络连接
     */
    private fun Context?.isNetConnected(): Boolean {
        if (this != null) {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null) {
                @Suppress("DEPRECATION")
                return networkInfo.isAvailable
            }
        }
        return false
    }

    /**
     * 保证运行在主线程
     */
    private fun runMain(block: () -> Unit) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            block()
        } else {
            Handler(Looper.getMainLooper()).post { block() }
        }
    }
}