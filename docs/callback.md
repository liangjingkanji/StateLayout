我们可以通过监听缺省页显示的生命周期来获取其对应的视图对象(View), 在其回调中可以拿到缺省页的任何控件(类似于Activity的`onCreate`)

| 函数 | 描述 |
|-|-|
| onEmpty | showEmpty 时回调 |
| onError | showError 时回调 |
| onContent | showContent 时回调 |
| onLoading | showLoading 时回调 |
| onRefresh | showLoading 时回调, 一般在其中执行加载网络或异步任务的逻辑, 而不是加载视图|
| stateChangedHandler | 完全接管缺省页状态变更时处理 |

每个StateLayout实例都可以设置单独的回调监听, 同时StateConfig可以设置全局的回调监听

>  你对缺省页有任何自定义的需求, 点击事件? 开始播放动画? 通过参数展示不同的错误页或者空页面? 都可以在这里判断! <br>
>  `show*()`函数可以通过其参数Any传递任何对象到`on*()`生命周期回调中

## 监听缺省页显示

=== "示例"
    ```kotlin
    state.onRefresh {
        // 每次showLoading都会执行该回调
    }
    state.showLoading()
    ```

=== "链式调用"
    ```kotlin

    state.onRefresh {
        // 每次showLoading都会执行该回调
    }.showLoading()
    ```

监听缺省页显示

=== "示例"
    ```kotlin
    state.onEmpty {
        findViewById<TextView>(R.id.msg).text = "空布局信息"
    }

    state.onError {

    }

    state.onLoading {

    }

    state.onRefresh {

    }

    state.onContent {

    }
    ```

=== "链式调用"
    ```kotlin
    state.onEmpty {

    }.onError {

    }.onLoading {

    }.onRefresh {

    }
    ```

`onRefresh`和`onLoading`触发的条件一样, 但是他们的函数参数接收者不一样, 他们所代表的的作用也不同

- onRefresh 中常见处理异步任务(例如网络请求)
- onLoading 中常见处理的是加载视图/动画

## 自定义缺省页切换处理

创建`StateChangedHandler`来取代默认的缺省页切换逻辑, 可以自定义缺省页显示/隐藏动画, 并且可以自定义布局参数(宽高)

StateChangedHandler默认是removeView/addView, 如果你想改成visibility就可以实现接口自定义处理

可以全部配置或者单例配置

```kotlin
// 单例
state.stateChangedHandler = StateChangedHandler()

// 全局
StateConfig.stateChangedHandler = StateChangedHandler()
```