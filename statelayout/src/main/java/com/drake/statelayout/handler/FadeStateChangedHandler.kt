package com.drake.statelayout.handler

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import com.drake.statelayout.StateChangedHandler
import com.drake.statelayout.StateLayout
import com.drake.statelayout.Status

/**
 * 切换状态时使用渐变透明动画. 显得缺省状态页不是那么生硬
 * @param duration 动画执行时间
 */
open class FadeStateChangedHandler(var duration: Long = 400) : StateChangedHandler {
    override fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {
        state.animate().setDuration(duration).alpha(0f).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                StateChangedHandler.onRemove(container, state, status, tag) // 等待动画执行完毕后删除旧的缺省页视图
            }
        }).start()
    }

    override fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {
        state.alpha = 0f
        super.onAdd(container, state, status, tag)
        state.animate().setDuration(duration).alpha(1f).start()
    }
}