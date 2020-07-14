/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：StateLayout
 * Author：drake
 * Date：7/14/20 2:23 PM
 */

package com.example.statelayout

import android.app.Application
import com.drake.statelayout.StateConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        StateConfig.apply {
            emptyLayout = R.layout.layout_empty
            errorLayout = R.layout.layout_error
            loadingLayout = R.layout.layout_loading

            setRetryIds(R.id.msg)
        }
    }
}