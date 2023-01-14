package com.drake.statelayout

import android.view.View

/**
 * 缺省页切换处理
 * 提供更丰富的缺省页切换处理, 可以自己决定是删除还是隐藏, 或者动态创建缺省页的布局参数甚至状态切换动画
 */
interface StateChangedHandler {

    /** 默认是删除/添加视图对象 */
    companion object DEFAULT : StateChangedHandler

    /**
     * StateLayout删除缺省页, 此方法比[onAdd]先执行
     * @param container StateLayout
     * @param state 将被删除缺省页视图对象
     * @param tag 显示状态传入的tag
     */
    fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {
        if (container.status != status) {
            state.visibility = View.GONE
        }
    }

    /**
     * StateLayout添加缺省页
     * @param container StateLayout
     * @param state 将被添加缺省页视图对象
     * @param tag 显示状态传入的tag
     */
    fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {
        if (container.indexOfChild(state) != -1) {
            state.visibility = View.VISIBLE
        } else {
            container.addView(state)
        }
    }
}