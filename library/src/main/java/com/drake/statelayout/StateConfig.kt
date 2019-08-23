package com.drake.statelayout

import android.view.View
import androidx.annotation.LayoutRes


/**
 * 全局的单列多状态布局配置
 */
object StateConfig {

    @LayoutRes
    var errorLayout = View.NO_ID
    @LayoutRes
    var emptyLayout = View.NO_ID
    @LayoutRes
    var loadingLayout = View.NO_ID

    internal var onEmpty: (View.() -> Unit)? = null
    internal var onError: (View.() -> Unit)? = null
    internal var onLoading: (View.() -> Unit)? = null

    fun onEmpty(block: View.() -> Unit) {
        onEmpty = block
    }

    fun onLoading(block: View.() -> Unit) {
        onLoading = block
    }

    fun onError(block: View.() -> Unit) {
        onError = block
    }
}