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
import com.drake.statelayout.StateConfig.emptyLayout
import com.drake.statelayout.StateConfig.errorLayout
import com.drake.statelayout.StateConfig.loadingLayout


/**
 * 全局的缺省页布局[StateLayout]配置
 * @property errorLayout 错误页布局的layoutRes, 如果[StateLayout.errorLayout]设置则该属性无效
 * @property emptyLayout 空页布局的layoutRes, 如果[StateLayout.emptyLayout]设置则该属性无效
 * @property loadingLayout 加载页布局的layoutRes, 如果[StateLayout.loadingLayout]设置则该属性无效
 */
object StateConfig {

    @LayoutRes
    var errorLayout = View.NO_ID

    @LayoutRes
    var emptyLayout = View.NO_ID

    @LayoutRes
    var loadingLayout = View.NO_ID

    internal var retryIds: List<Int>? = null
    internal var onEmpty: (View.(Any?) -> Unit)? = null
    internal var onError: (View.(Any?) -> Unit)? = null
    internal var onLoading: (View.(Any?) -> Unit)? = null

    /**
     * 执行全局配置的[onError]来处理错误布局生命周期
     * 一般在[StateLayout.onError]中执行, 即单例再次交由全局处理
     */
    fun handleError(v: View, tag: Any?) {
        onError?.invoke(v, tag)
    }

    /**
     * 执行全局配置的[onLoading]来处理加载中布局生命周期
     * 一般在[StateLayout.onLoading]中执行, 即单例再次交由全局处理
     */
    fun handleLoading(v: View, tag: Any?) {
        onLoading?.invoke(v, tag)
    }

    /**
     * 执行全局配置的[onEmpty]来处理空布局生命周期
     * 一般在[StateLayout.onEmpty]中执行, 即单例再次交由全局处理
     */
    fun handleEmpty(v: View, tag: Any?) {
        onEmpty?.invoke(v, tag)
    }

    /**
     * 全局的空页显示回调
     */
    fun onEmpty(block: View.(Any?) -> Unit) {
        onEmpty = block
    }

    /**
     * 全局的加载页显示回调
     */
    fun onLoading(block: View.(Any?) -> Unit) {
        onLoading = block
    }

    /**
     * 全局的错误页显示回调
     */
    fun onError(block: View.(Any?) -> Unit) {
        onError = block
    }

    /**
     * 全局的重试IdRes
     * 会自动给所有空布局和错误布局中的包含指定Id的控件全部加上一个点击事件
     * 该点击事件会触发[StateLayout.showLoading]
     * 点击事件500ms内防抖动
     */
    fun setRetryIds(@IdRes vararg ids: Int) {
        retryIds = ids.toList()
    }
}