在[生命周期](callback.md)中获取视图添加自定义动画

!!! warning "动画缺点"
    过度使用动画会拖慢响应速度, 用户使用体验可能不太好

## 缺省页显示动画

以下为缺省页渐变动画演示

<img src="https://i.loli.net/2021/08/14/97rDSVuKIodF1wO.gif" width="250"/>

1. 为避免重复代码首先创建统一的动画函数

    ```kotlin
    private fun View.startAnimation() {
        // 先将视图隐藏然后在800毫秒内渐变显示视图
        animate().setDuration(0).alpha(0F).withEndAction {
            animate().setDuration(800).alpha(1F)
        }
    }
    ```

2. 然后为每个缺省页设置动画

    ```kotlin
    StateConfig.apply {
        onError {
            startAnimation()
        }
        onEmpty {
            startAnimation()
        }
        onContent {
            startAnimation()
        }
        onLoading {
            startAnimation()
        }
    }
    ```

    当然也可以仅设置你指定的缺省页动画


## 缺省页切换动画

如果需要处理前一个状态的隐藏以及新的状态的显示, 那么就得实现接口`StateChangedHandler`自定义处理

框架自带一个渐变透明`FadeStateChangedHandler`

??? example "参考源码 FadeStateChangedHandler.kt"
    ```kotlin
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
    ```


可以全局/单例配置

```kotlin
StateConfig.stateChangedHandler = StateChangedHandler()
```