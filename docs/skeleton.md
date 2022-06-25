骨骼动画只是一种加载中状态动画, 你可以使用Gif图或者动画框架播放设计师提供的动画文件, 比如常用的[Lottie](https://airbnb.design/lottie/)动画框架创建包含动画控件的布局即可自动播放


<br>
[sample](https://github.com/liangjingkanji/StateLayout/blob/23b62cfe221639dd407bc1d61b3bdb27e1856ed0/app/src/main/java/com/example/statelayout/ui/activity/SkeletonAnimationActivity.kt)有演示使用Lottie动画框架+`StateChangedHandler`来演示如何构建完美的骨骼动画

以下属于自定义StateChangedHandler保证动画至少完整执行一次
```kotlin
/**
 * 适用于骨骼图动画, 能保证动画至少完整执行一次动画或者显示最短时间, 避免屏幕闪烁
 *
 * @param leastDuration 至少显示动画多长时间, 如果为null则至少显示动画完整播放一次的时间
 */
open class LeastAnimationStateChangedHandler(var leastDuration: Long? = null) :
    StateChangedHandler {

    /** 加载状态开始时间 */
    private var loadingStartTime = 0L
    private var next: View? = null
    private var animationPlaying = false

    override fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {
        if (status == Status.LOADING) {
            val animation = state.findViewById<LottieAnimationView>(R.id.lottie)
            animation?.addAnimatorUpdateListener {
                val duration = System.currentTimeMillis() - loadingStartTime
                if (duration >= leastDuration ?: it.duration) {
                    animationPlaying = false
                    animation.cancelAnimation()
                    animation.removeAllUpdateListeners()
                    container.removeAllViews()
                    next?.let { state -> if (state.parent == null) container.addView(state) }
                }
            }
        } else {
            StateChangedHandler.onRemove(container, state, status, tag)
        }
    }

    override fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {
        next = state
        if (animationPlaying) return
        super.onAdd(container, state, status, tag)
        if (status == Status.LOADING) {
            loadingStartTime = System.currentTimeMillis()
            state.findViewById<LottieAnimationView>(R.id.lottie)?.let {
                animationPlaying = true
                it.repeatCount = LottieDrawable.INFINITE
                it.playAnimation()
            }
        }
    }
}
```
