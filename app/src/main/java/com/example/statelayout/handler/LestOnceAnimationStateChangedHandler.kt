package com.example.statelayout.handler

import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.drake.statelayout.StateChangedHandler
import com.drake.statelayout.StateLayout
import com.drake.statelayout.Status
import com.example.statelayout.R

/**
 * 适用于骨骼图动画, 能保证动画至少完整执行一次动画, 避免屏幕闪烁
 */
open class LestOnceAnimationStateChangedHandler : StateChangedHandler {

    /** 加载状态开始时间 */
    private var loadingStartTime = 0L

    override fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {
        if (status == Status.LOADING) {
            val animation = state.findViewById<LottieAnimationView>(R.id.lottie)
            animation?.addAnimatorUpdateListener {
                val duration = System.currentTimeMillis() - loadingStartTime
                if (duration >= it.duration) {
                    animation.cancelAnimation()
                    animation.removeAllUpdateListeners()
                    StateChangedHandler.onRemove(container, state, status, tag)
                }
            }
        }
    }

    override fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {
        super.onAdd(container, state, status, tag)
        if (status == Status.LOADING) {
            loadingStartTime = System.currentTimeMillis()
            state.findViewById<LottieAnimationView>(R.id.lottie)?.let {
                it.repeatCount = LottieDrawable.INFINITE
                it.playAnimation()
            }
        }
    }
}