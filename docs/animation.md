在[生命周期](lifecycle.md)中就提到StateLayout可以直接监听获取到缺省页的视图对话, 很方便地添加自定义动画

> 不推荐盲目追求动画, 过度动画会拖慢应用响应速度, 用户使用体验可能不太好 <br>

## 缺省页显示动画

这里演示如何创建缺省页显示时播放渐变动画, 如果想要其他动画可以自己拓展

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

    当然你也可以仅设置你指定的缺省页动画


## 缺省页切换动画

上面介绍的只是显示动画, 我们可能还需要处理前一个状态的隐藏以及新的状态的显示, 那么就需要实现接口`StateChangedHandler`自定义处理

默认自带一个渐变透明处理者可以参考他的逻辑替换为其他动画框架

```kotlin
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
```


可以全局配置或者单例配置

```kotlin
// 单例
state.stateChangedHandler = StateChangedHandler()

// 全局
StateConfig.stateChangedHandler = StateChangedHandler()
```


## 骨骼动画

骨骼动画只是一种加载中状态动画, 你可以使用Gif图或者动画框架播放设计师提供的动画文件, 比如常用的[Lottie](https://airbnb.design/lottie/)动画框架创建一个xml布局包含动画控件即可自动播放

