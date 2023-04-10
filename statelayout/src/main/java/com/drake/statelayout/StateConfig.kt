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

package com.drake.statelayout

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes


/**
 * 全局的缺省页布局[StateLayout]配置
 */
object StateConfig {

    internal var retryIds: IntArray? = null
    internal var onEmpty: (View.(Any?) -> Unit)? = null
    internal var onError: (View.(Any?) -> Unit)? = null
    internal var onLoading: (View.(Any?) -> Unit)? = null
    internal var onContent: (View.(Any?) -> Unit)? = null

    /** 错误页布局的layoutRes, 如果[StateLayout.errorLayout]设置则该属性无效 */
    @LayoutRes
    @JvmStatic
    var errorLayout = View.NO_ID

    /** 空页布局的layoutRes, 如果[StateLayout.emptyLayout]设置则该属性无效 */
    @LayoutRes
    @JvmStatic
    var emptyLayout = View.NO_ID

    /** 加载页布局的layoutRes, 如果[StateLayout.loadingLayout]设置则该属性无效 */
    @LayoutRes
    @JvmStatic
    var loadingLayout = View.NO_ID

    /** 处理缺省页状态变更 */
    @JvmStatic
    var stateChangedHandler: StateChangedHandler = StateChangedHandler

    /**
     * 设置[setRetryIds]点击重试要求网络可用才会显示加载缺省,
     * 会回调[StateLayout.onRefresh]但不会回调[StateLayout.onLoading]
     * 为避免无网络情况下点击重试导致闪屏
     */
    var isNetworkingRetry = true

    /** 防抖动点击事件的间隔时间, 单位毫秒 */
    @JvmStatic
    var clickThrottle: Long = 500

    /**
     * 全局的空缺省页显示回调
     */
    @JvmStatic
    fun onEmpty(block: View.(Any?) -> Unit) {
        onEmpty = block
    }

    /**
     * 全局的错误缺省页显示回调
     */
    @JvmStatic
    fun onError(block: View.(Any?) -> Unit) {
        onError = block
    }

    /**
     * 全局的内容缺省页显示回调
     */
    @JvmStatic
    fun onContent(block: View.(Any?) -> Unit) {
        onContent = block
    }

    /**
     * 全局的加载中缺省页显示回调
     */
    @JvmStatic
    fun onLoading(block: View.(Any?) -> Unit) {
        onLoading = block
    }

    /**
     * 会为所有[StateLayout.emptyLayout]/[StateLayout.errorLayout]中的指定Id的视图对象添加一个点击事件
     * 该点击事件会触发[StateLayout.showLoading], 同时500ms内防抖动
     *
     * @see isNetworkingRetry 点击重试是否检查网络
     */
    @JvmStatic
    fun setRetryIds(@IdRes vararg ids: Int) {
        retryIds = ids
    }
}