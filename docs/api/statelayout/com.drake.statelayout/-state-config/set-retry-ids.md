[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateConfig](index.md) / [setRetryIds](./set-retry-ids.md)

# setRetryIds

`fun setRetryIds(@IdRes vararg ids: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

全局的重试IdRes
会自动给所有空布局和错误布局中的包含指定Id的控件全部加上一个点击事件
该点击事件会触发[StateLayout.showLoading](../-state-layout/show-loading.md)
点击事件500ms内防抖动

