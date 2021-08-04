我们可以通过监听缺省页显示的生命周期来获取其对应的视图对象(View), 在其回调中可以拿到缺省页的任何控件(类似于Activity的`onCreate`)

| 函数 | 描述 |
|-|-|
| [onEmpty](api/-state-layout/com.drake.statelayout/-state-layout/on-empty.html) | [showEmpty](api/-state-layout/com.drake.statelayout/-state-layout/show-empty.html)时回调 |
| [onError](api/-state-layout/com.drake.statelayout/-state-layout/on-error.html) | [showError](api/-state-layout/com.drake.statelayout/-state-layout/show-error.html)时回调 |
| [onContent](api/-state-layout/com.drake.statelayout/-state-layout/on-content.html) | [showContent](api/-state-layout/com.drake.statelayout/-state-layout/show-content.html)时回调 |
| [onLoading](api/-state-layout/com.drake.statelayout/-state-layout/on-loading.html) | [showLoading](api/-state-layout/com.drake.statelayout/-state-layout/show-loading.html)时回调 |
| [onRefresh](api/-state-layout/com.drake.statelayout/-state-layout/on-loading.html) | [showLoading](api/-state-layout/com.drake.statelayout/-state-layout/show-loading.html)时回调, 和`onLoading`不同的是该函数的`this`是StateLayout, 一般在其中执行加载网络或异步任务的逻辑, 而不是加载视图|

每个StateLayout实例都可以设置单独的回调监听, 同时StateConfig可以设置全局的回调监听

>  你对缺省页有任何自定义的需求, 点击事件? 开始播放动画? 通过参数展示不同的错误页或者空页面? 都可以在这里判断! <br>
>  `show*()`函数可以通过其参数Any传递任何对象到`on*()`生命周期回调中

监听加载

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

这里可以看到onRefresh和onLoading触发的条件一样, 但是他们的函数参数接收者不一样, 他们所代表的的作用也不同.

1. onRefresh 回调中处理加载时其异步任务(例如网络请求)
1. onLoading 中则处理的是加载视图UI