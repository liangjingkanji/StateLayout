[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateConfig](./index.md)

# StateConfig

`object StateConfig`

全局的缺省页布局[StateLayout](../-state-layout/index.md)配置

### Properties

| Name | Summary |
|---|---|
| [emptyLayout](empty-layout.md) | 空页布局的layoutRes, 如果[StateLayout.emptyLayout](../-state-layout/empty-layout.md)设置则该属性无效`var emptyLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [errorLayout](error-layout.md) | 错误页布局的layoutRes, 如果[StateLayout.errorLayout](../-state-layout/error-layout.md)设置则该属性无效`var errorLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [loadingLayout](loading-layout.md) | 加载页布局的layoutRes, 如果[StateLayout.loadingLayout](../-state-layout/loading-layout.md)设置则该属性无效`var loadingLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [handleEmpty](handle-empty.md) | 执行全局配置的[onEmpty](on-empty.md)来处理空布局生命周期 一般在[StateLayout.onEmpty](../-state-layout/on-empty.md)中执行, 即单例再次交由全局处理`fun handleEmpty(v: View, tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleError](handle-error.md) | 执行全局配置的[onError](on-error.md)来处理错误布局生命周期 一般在[StateLayout.onError](../-state-layout/on-error.md)中执行, 即单例再次交由全局处理`fun handleError(v: View, tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleLoading](handle-loading.md) | 执行全局配置的[onLoading](on-loading.md)来处理加载中布局生命周期 一般在[StateLayout.onLoading](../-state-layout/on-loading.md)中执行, 即单例再次交由全局处理`fun handleLoading(v: View, tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onEmpty](on-empty.md) | 全局的空页显示回调`fun onEmpty(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | 全局的错误页显示回调`fun onError(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onLoading](on-loading.md) | 全局的加载页显示回调`fun onLoading(block: View.(`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setRetryIds](set-retry-ids.md) | 全局的重试IdRes 会自动给所有空布局和错误布局中的包含指定Id的控件全部加上一个点击事件 该点击事件会触发[StateLayout.showLoading](../-state-layout/show-loading.md) 点击事件500ms内防抖动`fun setRetryIds(vararg ids: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
