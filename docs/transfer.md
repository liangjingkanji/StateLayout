某些情况下我们不同时候显示的缺省页存在微小差距

例如我的项目中服务器异常500和请求参数错误400显示的提示文字有所区别

1. 请求参数错误要求显示后端的错误码和错误信息
2. 后端错误显示 "无法找到服务器"

<br>

显示缺省页函数
```kotlin
fun showLoading(tag: Any? = null, refresh: Boolean = true)
// 显示加载页面
// tag: 传递的tag将被[onLoading]接收
// refresh: 是否调用刷新回调[onRefresh], onLoading总会被执行

fun showEmpty(tag: Any? = null)
// 显示空页面
// tag: 传递的tag将被[onEmpty]接收

fun showError(tag: Any? = null)
// 显示错误页面
// tag: 传递的tag将被[onError]接收

fun showContent()
// 显示内容页面
```
`tag`即传递的参数, 在监听事件中会被收到(即`Any`), 默认为null

监听事件函数
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