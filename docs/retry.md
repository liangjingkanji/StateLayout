一般错误页面都会存在一个点击重试的按钮, 本库也简化了该操作

```kotlin tab="单例设置点击重试Id"
state.setRetryIds(R.id.msg) // 会触发[onRefresh]
```

```kotlin tab="全局设置点击重试Id"
StateConfig.setRetryIds(R.id.msg) // 会触发[onRefresh]
```

函数
```kotlin
fun setRetryIds(@IdRes vararg ids: Int): StateLayout
// 可变参数接收多个点击重试的Id
```

通过你设置的Id会自动在错误页面和空布局页面`findViewById`查找到对应Id的控件设置点击事件, 点击事件执行`showLoading`.
会自动触发`onRefresh/onLoading`回调

<br>

!!! tip
    空页面也同样支持点击重试