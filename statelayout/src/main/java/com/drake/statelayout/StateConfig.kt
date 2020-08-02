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
 * 全局的多状态布局配置
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

    fun handleError(v: View, tag: Any?) {
        onError?.invoke(v, tag)
    }

    fun handleLoading(v: View, tag: Any?) {
        onLoading?.invoke(v, tag)
    }

    fun handleEmpty(v: View, tag: Any?) {
        onEmpty?.invoke(v, tag)
    }

    fun onEmpty(block: View.(Any?) -> Unit) {
        onEmpty = block
    }

    fun onLoading(block: View.(Any?) -> Unit) {
        onLoading = block
    }

    fun onError(block: View.(Any?) -> Unit) {
        onError = block
    }

    fun setRetryIds(@IdRes vararg ids: Int) {
        retryIds = ids.toList()
    }
}