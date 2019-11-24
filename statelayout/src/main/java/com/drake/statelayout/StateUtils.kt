/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：StateLayout
 * Author：Drake
 * Date：9/11/19 5:30 PM
 */
@file:Suppress("unused")
package com.drake.statelayout

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

fun Activity.state(): StateLayout {
    val view = (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0)
    return view.state()
}

fun Fragment.state(): StateLayout {
    val stateLayout = view!!.state()

    lifecycle.addObserver(object : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun removeState() {
            val parent = stateLayout.parent as ViewGroup
            parent.removeView(stateLayout)
            lifecycle.removeObserver(this)
        }
    })

    return stateLayout
}

fun View.state(): StateLayout {
    val stateLayout = StateLayout(context)
    val parent = parent as ViewGroup
    stateLayout.id = id
    val index = parent.indexOfChild(this)
    val layoutParams = layoutParams
    parent.removeView(this)
    parent.addView(stateLayout, index, layoutParams)

    if (this is ConstraintLayout) {
        val contentViewLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        stateLayout.addView(this, contentViewLayoutParams)
    } else {
        stateLayout.addView(this)
    }
    stateLayout.setContentView(this)

    return stateLayout
}