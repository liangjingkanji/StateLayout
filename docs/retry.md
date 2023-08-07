在错误/空状态可以点击图片或按钮进行重新亲戚

### 快速配置

!!! note "原理"
    点击你传入的控件ID后自动调用`showLoading()`, 支持错误/空两种状态

=== "单例"
    ```kotlin 
    state.setRetryIds(R.id.msg)
    ```

=== "全局"
    ```kotlin 
    StateConfig.setRetryIds(R.id.msg)
    ```

### 自定义重试

可以自己在生命周期回调中为View设置点击事件

```kotlin
binding.state.onError {
    findViewById<View>(R.id.image).setOnClickListener {
        binding.state.showLoading()
    }
}
```

更多自定义请见[生命周期](docs/callback.md)