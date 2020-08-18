应用大部分页面其实缺省页都是相同的布局, 如果每个页面的缺省页都需要指定就显得很麻烦了, 所以推荐使用全局缺省页配置

全部配置由该单例对象[StateConfig](https://github.com/liangjingkanji/StateLayout/blob/master/statelayout/src/main/java/com/drake/statelayout/StateConfig.kt)来配置

```kotlin
StateConfig.apply {
    emptyLayout = R.layout.layout_empty // 配置全局的空布局
    errorLayout = R.layout.layout_error // 配置全局的错误布局
    loadingLayout = R.layout.layout_loading // 配置全局的加载中布局

    setRetryIds(R.id.msg) // 全局的重试Id

    onLoading {

    }

    onEmpty {

    }

    onError {

    }
}
```

!!! note
    单例可以覆盖全局的配置, 单例即当前页面的`StateLayout`