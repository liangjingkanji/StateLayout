package com.drake.statelayout.handler

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import com.drake.statelayout.StateChangedHandler
import com.drake.statelayout.StateChangedHandler.DEFAULT.onAdd
import com.drake.statelayout.StateLayout
import com.drake.statelayout.Status
import java.lang.ref.WeakReference

/**
 * 切换状态时使用渐变透明动画过渡
 * @param duration 动画执行时间
 */
open class FadeStateChangedHandler(var duration: Long = 400) : StateChangedHandler {

    private var stateLayout: WeakReference<StateLayout> = WeakReference(null)

    /**
     * StateLayout删除缺省页, 此方法比[onAdd]先执行
     * @param container StateLayout
     * @param state 将被删除缺省页视图对象
     * @param status 当前状态
     * @param tag 显示状态传入的tag
     */
    override fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {
        if (container != stateLayout.get() && status == Status.LOADING) {
            return super.onRemove(container, state, status, tag)
        }
        state.animate().setDuration(duration).alpha(0f).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // 等待动画执行完毕后删除旧的缺省页视图
                StateChangedHandler.onRemove(container, state, status, tag)
            }
        }).start()
    }

    /**
     * StateLayout添加缺省页
     * @param container StateLayout
     * @param state 将被添加缺省页视图对象
     * @param status 当前状态
     * @param tag 显示状态传入的tag
     */
    override fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {
        // 初次加载不应用动画
        if (container != stateLayout.get() && status == Status.LOADING) {
            stateLayout = WeakReference(container)
            return StateChangedHandler.onAdd(container, state, status, tag)
        }
        super.onAdd(container, state, status, tag)
        state.alpha = 0f
        state.animate().setDuration(duration).alpha(1f).start()
    }
}