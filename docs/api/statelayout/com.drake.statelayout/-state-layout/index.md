[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateLayout](./index.md)

# StateLayout

`class StateLayout : FrameLayout`

简单配置缺省页

全局配置
单例配置
支持代码或者布局创建
无网络情况下showLoading显示错误布局, 有网则显示加载中布局

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | 简单配置缺省页`StateLayout(context: Context, attrs: AttributeSet? = null, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)` |

### Properties

| Name | Summary |
|---|---|
| [emptyLayout](empty-layout.md) | 空页的layoutRes`var emptyLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [errorLayout](error-layout.md) | 错误页的layoutRes`var errorLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [loaded](loaded.md) | 当前缺省页是否加载成功过, 即是否执行过[showContent](show-content.md)`var loaded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadingLayout](loading-layout.md) | 加载页的layoutRes`var loadingLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [status](status.md) | 当前缺省页状态[Status](../-status/index.md)`var status: `[`Status`](../-status/index.md) |

### Functions

| Name | Summary |
|---|---|
| [isNetConnected](is-net-connected.md) | 判断是否有网络连接`fun Context?.isNetConnected(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onEmpty](on-empty.md) | 当空缺省页显示时回调`fun onEmpty(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateLayout`](./index.md) |
| [onError](on-error.md) | 当错误缺省页显示时回调`fun onError(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateLayout`](./index.md) |
| [onFinishInflate](on-finish-inflate.md) | `fun onFinishInflate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onLoading](on-loading.md) | 当加载中缺省页显示时回调`fun onLoading(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateLayout`](./index.md) |
| [onRefresh](on-refresh.md) | 当[showLoading](show-loading.md)时会回调该函数参数, 一般将网络请求等异步操作放入其中`fun onRefresh(block: `[`StateLayout`](./index.md)`.(loading: View) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateLayout`](./index.md) |
| [setContentView](set-content-view.md) | 标记视图为内容布局, 用于扩展替换内容. 一般情况不需要使用`fun setContentView(view: View): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setRetryIds](set-retry-ids.md) | 错误页/空页中的布局控件包含指定IdRes的会设置点击事件, 该点击事件会触发[StateLayout.showLoading](show-loading.md) 点击事件500ms内防抖动`fun setRetryIds(vararg ids: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StateLayout`](./index.md) |
| [showContent](show-content.md) | 显示内容布局, 表示成功缺省页`fun showContent(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showEmpty](show-empty.md) | 显示空页, 会触发[onEmpty](on-empty.md)的函数参数`fun showEmpty(tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showError](show-error.md) | 显示错误页, 会触发[onError](on-error.md)的函数参数`fun showError(tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showLoading](show-loading.md) | 有网则显示加载中, 无网络直接显示错误, 会触发[onLoading](on-loading.md)的函数参数`fun showLoading(tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`? = null, refresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [trigger](trigger.md) | 一般情况下开发者无需关心, 这属于配合其他框架预览函数`fun trigger(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
