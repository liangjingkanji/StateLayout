
`showXX()`函数显示缺省页时传入参数`tag`, 在`onXX()`回调中接收`tag`并处理

## 使用

例如根据不同状态码, 服务器异常500/请求参数错误400 区分提示文字

1. 400 显示 错误码/错误信息
2. 500 显示 "无法找到服务器"

```kotlin
state.showError(ResponseException(code = 403, msg = "请求参数错误"))
```

=== "单例错误监听"
    ```kotlin
    state.onError {
        if (it is ResponseException) {
            findViewById<TextView>.text = "错误码: ${it.code}, 错误信息: ${it.msg}"
        }
    }
    ```

=== "全局错误监听"
    ```kotlin
    StateConfig.onError {
        if (it is ResponseException) {
            findViewById<TextView>.text = "错误码: ${it.code}, 错误信息: ${it.msg}"
        }
    }
    ```