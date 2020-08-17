[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateLayout](index.md) / [onRefresh](./on-refresh.md)

# onRefresh

`fun onRefresh(block: `[`StateLayout`](index.md)`.(loading: View) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateLayout`](index.md)

当[showLoading](show-loading.md)时会回调该函数参数, 一般将网络请求等异步操作放入其中

