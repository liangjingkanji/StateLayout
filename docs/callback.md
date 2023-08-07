生命周期回调中可以获取状态参数/视图对象

| 函数 | 描述 |
|-|-|
| onEmpty | showEmpty 时回调 |
| onError | showError 时回调 |
| onContent | showContent 时回调 |
| onLoading | showLoading 时回调 |
| onRefresh | showLoading 时回调, 一般在其中执行加载网络异步任务|
| stateChangedHandler | 完全接管缺省页状态变更时处理 |

## 监听缺省页显示

```kotlin
state.onRefresh {
    // 执行请求
}.showLoading()
```

监听缺省页显示

```kotlin
state.onEmpty {

}.onError {

}.onLoading {

}.onRefresh {

}
```

`onRefresh`和`onLoading`触发条件相同, 但是参数不同, 他们所代表的的作用也不同

1. `onRefresh` 中常见处理网络请求异步任务
2. `onLoading` 中常见处理的是加载视图/动画

## 完全自定义

实现`StateChangedHandler`可以实现最大程度自定义

甚至来取代默认的缺省页切换逻辑, 可以自定义缺省页显示/隐藏动画, 并且可以自定义布局参数(宽高)

```kotlin
// 单例
state.stateChangedHandler = StateChangedHandler()

// 全局
StateConfig.stateChangedHandler = StateChangedHandler()
```

StateChangedHandler默认是removeView/addView, 如果你想改成visibility就请自定义