一般错误页面都会存在一个点击重试的按钮, 本库也简化了该操作

### 设置重试Id

点击重试原理是点击你传入的控件ID后自动调用`showLoading()`, 支持ERROR/EMPTY两种状态

默认情况下仅有网络才会显示LOADING缺省页(onRefresh不要求网络), 这是为了避免很快闪过LOADING. 可以自定义点击重试避免这一要求

=== "单例设置点击重试Id"
    ```kotlin 
    state.setRetryIds(R.id.msg) // 会触发[onRefresh]
    ```

=== "全局设置点击重试Id"
    ```kotlin 
    StateConfig.setRetryIds(R.id.msg) // 会触发[onRefresh]
    ```

函数
```kotlin
fun setRetryIds(@IdRes vararg ids: Int): StateLayout
// 可变参数接收多个点击重试的Id
```


### 自定义重试

如果你对默认的点击重试不满意, 可以在生命周期方法中自己`setOnClickListener`来配置自动重试

更自定义的请见[生命周期](docs/callback.md), 你可以在其缺省页的生命周期回调中获取对应的控件(View)来设置`setOnClickListener`设置点击事件来响应你的任何逻辑