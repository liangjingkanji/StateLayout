[statelayout](../../index.md) / [com.drake.statelayout](../index.md) / [StateConfig](index.md) / [handleEmpty](./handle-empty.md)

# handleEmpty

`fun handleEmpty(v: View, tag: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

执行全局配置的[onEmpty](on-empty.md)来处理空布局生命周期
一般在[StateLayout.onEmpty](../-state-layout/on-empty.md)中执行, 即单例再次交由全局处理

