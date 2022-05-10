在[生命周期](lifecycle.md)中就提到StateLayout可以直接监听获取到缺省页的视图对话, 很方便地添加自定义动画.

> 我并不推荐为缺省页设置动画, 毕竟页面追求的是立即显示内容给用户. 动画严重拖慢应用响应速度, 体验不太好 <br>

## 缺省页显示动画

这里演示如何创建渐变动画, 如果想要其他动画可以自己拓展

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
        emptyLayout = R.layout.layout_empty
        errorLayout = R.layout.layout_error
        loadingLayout = R.layout.layout_loading
    
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

创建StateChangedHandler来取代默认的缺省页切换逻辑, 可以自定义缺省页显示/隐藏动画, 并且可以自定义布局参数(宽高)

```kotlin
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
    open fun onAdd(container: StateLayout, state: View, tag: Any?) {
        container.addView(state)
    }

    /**
     * StateLayout删除缺省页
     * @param container StateLayout
     * @param state 将被删除缺省页视图对象
     * @param tag 显示状态传入的tag
     */
    open fun onRemove(container: StateLayout, state: View, tag: Any?) {
        container.removeView(state)
    }
}
```

可以全部配置或者单例配置

```kotlin
// 单例
state.stateChangedHandler = StateChangedHandler()

// 全局
StateConfig.stateChangedHandler = StateChangedHandler()
```


## 骨骼动画

骨骼动画只是一种加载中动画. 你可以使用第三方骨骼动画框架(甚至一个gif动图)设置为`loadingLayout`(加载中缺省页)即可

