package com.drake.statelayout

import android.view.View

/**
 * 缺省页切换处理
 * 提供更丰富的缺省页切换处理, 可以自己决定是删除还是隐藏, 或者动态创建缺省页的布局参数甚至状态切换动画
 */
open class StateChangedHandler {

    /**
     * StateLayout添加缺省页
     * @param container StateLayout
     * @param state 将被添加缺省页视图对象
     * @param tag 显示状态传入的tag
     */
    open fun onAdd(container: StateLayout, state: View, statue: Status, tag: Any?) {
        container.addView(state)
    }

    /**
     * StateLayout删除缺省页
     * @param container StateLayout
     * @param state 将被删除缺省页视图对象
     * @param tag 显示状态传入的tag
     */
    open fun onRemove(container: StateLayout, state: View, statue: Status, tag: Any?) {
        container.removeView(state)
    }
}