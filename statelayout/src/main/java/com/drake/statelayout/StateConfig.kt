/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：StateLayout
 * Author：Drake
 * Date：9/11/19 5:30 PM
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
    internal var onEmpty: (View.(StateLayout) -> Unit)? = null
    internal var onError: (View.(StateLayout) -> Unit)? = null
    internal var onLoading: (View.(StateLayout) -> Unit)? = null


    fun onEmpty(block: View.(StateLayout) -> Unit) {
        onEmpty = block
    }

    fun onLoading(block: View.(StateLayout) -> Unit) {
        onLoading = block
    }

    fun onError(block: View.(StateLayout) -> Unit) {
        onError = block
    }

    fun setRetryIds(@IdRes vararg ids: Int) {
        retryIds = ids.toList()
    }
}