StateLayout只包含四种状态

1. 错误状态
1. 空状态
1. 加载中状态
1. 内容(StateLayout包裹的视图)

<br>
如果需要新增一种状态, 例如错误分为网络/业务错误, 可以使用`标签(tag)`来区分处理


### 示例

传递标签
```kotlin
showError(NetNetworkingException()) // 传递异常对象作为标签
```


配置全局视图回调

```kotlin
StateConfig.onError {
    if (it is NetNetworkingException) {
        // 为无网络异常展示不同图片, 当然你也可以addView
        findViewById<View>(R.id.iv_error).setImageResource(R.drawable.ic_networking_error)
    }
}
```

更多自定义请见 [StateChangedHandler](callback.md#_2)
