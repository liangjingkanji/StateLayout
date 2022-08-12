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
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

/**
 * 创建一个缺省页来包裹Activity, 请注意反复调用本方法会反复创建[StateLayout]导致发生问题
 * 本方法不推荐使用, 建议在Xml布局中创建[StateLayout], 可保持代码可读性且避免不必要的问题发生, 性能也更优
 */
fun Activity.stateCreate(): StateLayout {
    val view = (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0)
    return view.stateCreate()
}

/**
 * 创建一个缺省页来包裹Fragment, 请注意反复调用本方法会反复创建[StateLayout]导致发生问题
 * 本方法不推荐使用, 建议在Xml布局中创建[StateLayout], 可保持代码可读性且避免不必要的问题发生, 性能也更优
 */
fun Fragment.stateCreate(): StateLayout {
    val stateLayout = requireView().stateCreate()

    viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun removeState() {
            val parent = stateLayout.parent as ViewGroup
            parent.removeView(stateLayout)
            lifecycle.removeObserver(this)
        }
    })

    return stateLayout
}

/**
 * 创建一个缺省页来包裹视图, 请注意反复调用本方法会反复创建[StateLayout]导致发生问题
 * 本方法不推荐使用, 建议在Xml布局中创建[StateLayout], 可保持代码可读性且避免不必要的问题发生, 性能也更优
 */
fun View.stateCreate(): StateLayout {
    val parent = parent as ViewGroup
    if (parent is ViewPager || parent is RecyclerView) {
        throw UnsupportedOperationException("You should using StateLayout wrap [ $this ] in layout when parent is ViewPager or RecyclerView")
    }
    val stateLayout = StateLayout(context)
    stateLayout.id = id
    val index = parent.indexOfChild(this)
    val layoutParams = layoutParams
    parent.removeView(this)
    parent.addView(stateLayout, index, layoutParams)

    when (this) {
        is ConstraintLayout -> {
            val contentViewLayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            stateLayout.addView(this, contentViewLayoutParams)
        }
        else -> {
            stateLayout.addView(this)
        }
    }

    stateLayout.setContent(this)
    return stateLayout
}