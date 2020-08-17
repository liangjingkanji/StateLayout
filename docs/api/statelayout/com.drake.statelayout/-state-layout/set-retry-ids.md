[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateLayout](index.md) / [setRetryIds](./set-retry-ids.md)

# setRetryIds

`fun setRetryIds(@IdRes vararg ids: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StateLayout`](index.md)

错误页/空页中的布局控件包含指定IdRes的会设置点击事件, 该点击事件会触发[StateLayout.showLoading](show-loading.md)
点击事件500ms内防抖动

