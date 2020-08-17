[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateLayout](index.md) / [showLoading](./show-loading.md)

# showLoading

`fun showLoading(tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`? = null, refresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

有网则显示加载中, 无网络直接显示错误, 会触发[onLoading](on-loading.md)的函数参数

### Parameters

`tag` - 传递的tag将被[onLoading](on-loading.md)接收

`refresh` - 是否调用刷新回调[onRefresh](on-refresh.md)