在Application中可以使用[StateConfig](https://github.com/liangjingkanji/StateLayout/blob/master/statelayout/src/main/java/com/drake/statelayout/StateConfig.kt)进行初始化配置

```kotlin
StateConfig.apply {
    emptyLayout = R.layout.layout_empty
    errorLayout = R.layout.layout_error
    loadingLayout = R.layout.layout_loading

    setRetryIds(R.id.msg) // 全局的重试Id

    onLoading {

    }

    onEmpty {

    }

    onError {

    }
}
```