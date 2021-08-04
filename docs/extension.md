
## 列表缺省页

如果你需要列表显示缺省页我更推荐直接使用[BRV](https://liangjingkanji.github.io/BRV/state.html)

BRV是一个代码简洁多功能的无需创建Adapter的RecyclerView列表库
BRV内嵌StateLayout无需再次包裹, 故也支持StateConfig的配置. BRV支持下拉刷新/上拉加载/静默加载/预加载/预拉取

> 项目添加BRV依赖后就不用再依赖StateLayout了. 因为BRV已经包含StateLayout

依赖[BRV](https://github.com/liangjingkanji/BRV/)依赖库

[![](https://jitpack.io/v/liangjingkanji/Net.svg)](https://github.com/liangjingkanji/Net/)

```groovy
dependencies {
    implementation 'com.github.liangjingkanji:Net:+'
}
```
推荐使用指定的版本号替换`+`

框架可以实现以下功能

1. [缺省页](https://liangjingkanji.github.io/BRV/state)
1. [下拉刷新/上拉加载/缺省页](https://liangjingkanji.github.io/BRV/refresh)
1. [拉取更多](https://liangjingkanji.github.io/BRV/upfetch)
1. [预加载/预拉取](https://liangjingkanji.github.io/BRV/preload)

## 网络请求缺省页

如果你需要让网络请求自动处理缺省页的显示/隐藏. 推荐使用[Net](https://liangjingkanji.github.io/Net/auto-state.html)配合StateLayout或者BRV

Net是一个第三方的强大的网络请求/异步任务框架, 非常优秀的设计, 可以和BRV或者StateLayout联动. 完全不需要自己去处理缺省页显示

依赖[Net](https://github.com/liangjingkanji/Net/)依赖库

[![](https://jitpack.io/v/liangjingkanji/Net.svg)](https://github.com/liangjingkanji/Net/)

```groovy
dependencies {
    implementation 'com.github.liangjingkanji:Net:+'
}
```
推荐使用指定的版本号替换`+`

配合[Net](https://github.com/liangjingkanji/Net/)框架可以实现以下功能

- [自动下拉刷新](https://liangjingkanji.github.io/Net/auto-refresh/)
- [自动分页加载](https://liangjingkanji.github.io/Net/auto-page/)
- [自动缺省页](https://liangjingkanji.github.io/Net/auto-state/)
