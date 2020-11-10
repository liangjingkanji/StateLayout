[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateLayout](index.md) / [showLoading](./show-loading.md)

# showLoading

`fun showLoading(tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`? = null, silent: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, refresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

有网则显示加载中, 无网络直接显示错误, 会触发[onLoading](on-loading.md)的函数参数

### Parameters

`tag` - 传递参数将被[onLoading](on-loading.md)接收

`silent` - 仅调用[onRefresh](on-refresh.md)

`refresh` - 是否调用[onRefresh](on-refresh.md)