骨骼动画只是一种加载中状态动画

一般使用设计师提供的动画文件(或Gif图), 比如常用的[Lottie](https://airbnb.design/lottie/)就支持创建骨骼动画


在示例项目中提供自定义`LeastAnimationStateChangedHandler`来实现骨骼动画, 解决以下问题

!!! note "实现原理"
    实际上做的事很简单, 也就是保证动画最短执行时间, 避免请求过快导致骨骼动画一闪而过

[骨骼动画示例](https://github.com/liangjingkanji/StateLayout/blob/23b62cfe221639dd407bc1d61b3bdb27e1856ed0/app/src/main/java/com/example/statelayout/ui/activity/SkeletonAnimationActivity.kt)