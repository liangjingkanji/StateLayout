一般错误页面都会存在一个点击重试的按钮, 本库也简化了该操作

### 设置重试Id

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

通过你设置的Id会自动在错误页面和空布局页面`findViewById`查找到对应Id的控件设置点击事件, 点击事件执行`showLoading`.
会自动触发`onRefresh/onLoading`回调


> 是大神大大

<br>

!!! note
    空页面也同样支持点击重试 <br>


### 自定义重试

`setRetryIds`函数触发的`onRefresh/onLoading`回调中的it都是Null, 你可以通过这个来区分是否是设置的重试Id触发的, 借此达到监听是用户点击重试还是你自己`showLoading`


更自定义的请见[生命周期](docs/lifecycle.md), 你可以在其缺省页的生命周期回调中获取对应的控件(View)来设置`setOnClickListener`设置点击事件来响应你的任何逻辑