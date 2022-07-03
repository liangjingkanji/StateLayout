默认包含四种状态: 错误/空/加载中/内容


如果我们需要新增一种状态(例如错误分为网络/接口错误), 我们可以根据`tag`来在[视图回调](callback.md)中进行处理(比如替换图片)


### 示例

传递标签
```kotlin
val e = NetNetworkingException()
showError(e) // 这里直接传递异常对象过去, 实际你可以传递任何对象
```


配置全局视图回调

```kotlin
StateConfig.apply {
    onError {
        if (it is NetNetworkingException) {
            // 这里是为无网络异常展示不同图片, 当然你可以做其他处理, 比如addView或者setText
            findViewById<View>(R.id.iv_error).setImageResource(R.drawable.ic_networking_error)
        }
    }
}
```

或者你直接自定义StateChangedHandler也可以根据`tag`来addView, 但是我认为`onError`等方法足以, 也更简单


> 缺省页不同的状态就是添加不同的视图对象, 或显示不同图片/文字, 通过tag我们可以实现无限多种状态(类似网络拦截器)