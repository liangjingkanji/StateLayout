一般错误页面都会存在一个点击重试的按钮, 本库也简化了该操作

```kotlin
state.setRetryIds(R.id.msg) // 会触发[onRefresh]
```

函数
```kotlin
fun setRetryIds(@IdRes vararg ids: Int): StateLayout
// 可变参数接收多个点击重试的Id
```

!!! tip
    空页面也同样支持点击重试