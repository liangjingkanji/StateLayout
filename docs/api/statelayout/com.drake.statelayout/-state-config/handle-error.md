[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateConfig](index.md) / [handleError](./handle-error.md)

# handleError

`fun handleError(v: View, tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

执行全局配置的[onError](on-error.md)来处理错误布局生命周期
一般在[StateLayout.onError](../-state-layout/on-error.md)中执行, 即单例再次交由全局处理

