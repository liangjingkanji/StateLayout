我们可以通过监听缺省页显示的生命周期来获取其对应的视图对象(View), 在其回调中可以拿到缺省页的任何控件

```kotlin
fun onEmpty(block: View.(Any?) -> Unit): StateLayout
// showEmpty() 时回调
fun onError(block: View.(Any?) -> Unit): StateLayout
// showError() 时回调
fun onLoading(block: View.(Any?) -> Unit): StateLayout
// showLoading() 时回调
fun onRefresh(block: StateLayout.(loading: View) -> Unit): StateLayout
// showLoading() 时回调
```

监听加载

=== "示例"
    ```kotlin
    state.onRefresh {
        // 每次showLoading都会执行该回调
        find
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

    }

    state.onError {

    }

    state.onLoading {
        findViewById<TextView>(R.id.msg).text = "空布局信息"
    }

    state.onRefresh {

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