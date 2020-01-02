## StateLayout

Android上最强大的缺省页(状态页面)工具



特点

 * 全局配置
 * 单例配置
 * 生命周期(可以加载动画或者处理事件)
 * 刷新回调
 * 获取当前缺省页状态
 * Loading缺省页支持进度回调
 * 支持activity/fragment/view替换
 * 支持Java或者XML实现
 * 无网络情况下showLoading显示错误布局, 有网则显示加载中布局
 * 支持配合RecyclerView的下拉刷新
 * 支持配合网络请求自动化显示
 * 异步线程显示缺省页
 * 可以将数据作为tag传给页面回调函数处理



配合网络请求库可以做到自动处理缺省页: [Net](https://github.com/liangjingkanji/Net)

### 依赖

project 的 build.gradle

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```



module 的 build.gradle

```groovy
implementation 'com.github.liangjingkanji:StateLayout:1.0.9'
```

### 常见问题

先设置生命周期函数`on**()`, 再显示缺省页`show**()`才会执行生命周期函数



### 显示缺省页

```
showLoading(tag:Any? = null, refresh:Boolean = true) // 参数表示是否回调onRefresh函数
showEmpty(tag:Any? = null)
showContent(tag:Any? = null)
showError(tag:Any? = null)
```



1. showLoading重复执行不会回调onRefresh, 但是会一直回调onLoading, 可以在其回调中进行进度变更

### 全局状态配置

或者也可以称为默认状态内容, 全局配置即以后都不需要在每个界面中指定缺省页显示内容, 都会默认读取全局配置. 如果不需要全局可以不写.

通过`StateConfig`单例对象控制

```kotlin
class MyApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        StateConfig.apply {
            emptyLayout = R.layout.layout_empty
            errorLayout = R.layout.layout_error
            loadingLayout = R.layout.layout_loading

            onLoading {
                // do animation, this object = view object
            }
        }
    }
}
```



可配置项

-   缺省页布局
-   生命周期回调函数
-   重试ids



#### 生命周期函数

`onError|onLoading|onEmpty`系列函数, 每次在显示缺省页时都会执行. 一般情况是在回调中对布局中的视图进行设置动画

#### 刷新回调

`onRefresh`函数在每次`showLoading`时候都会回调

```kotlin
onRefresh {
    thread {
        Thread.sleep(2000) // 模拟2s的网络请求
        showContent()
    }
}

showLoading()
```



#### 重试Ids

errorLayout布局中的对应ids的视图对象会在点击时自动`showLoading`, 全局和单例都支持设置, 设置单例后全局就不会继续作用于当前缺省页.

```kotlin
fun setRetryIds(@IdRes vararg ids: Int)
```

-   这是覆盖不是添加
-   500ms内防止重复点击



### 单例状态配置

级别优先于全局状态配置

```kotlin
state = state().apply {
  emptyLayout = R.layout.layout_empty

  onError {
    // can retry request
  }
}
```



### 显示缺省页

通过`show**`函数

```kotlin
override fun onOptionsItemSelected(item: MenuItem): Boolean {
  when (item.itemId) {
    R.id.menu_loading -> state.showLoading()
    R.id.menu_content -> state.showContent()
    R.id.menu_error -> state.showError()
    R.id.menu_empty -> state.showEmpty()
  }
  return true
}
```



### 布局配置

StateLayout其实也可以在XML布局中声明创建

```xml
    <com.drake.library.StateLayout
        app:empty_layout="@layout/layout_empty"
        app:error_layout="@layout/layout_error"
        app:loading_layout="@layout/layout_loading"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        <!-- content -->
        
    </com.drake.library.StateLayout>
```



### 扩展

在`StateUtils`文件中存在一系列基于Kotlin特性的工具函数, 用于快速创建一个StateLayout

```kotlin
fun Activity.state(): StateLayout

fun Fragment.state(): StateLayout

fun View.state(): StateLayout 
```



此框架同时被整合到我的RecyclerView库 [BRV](https://github.com/liangjingkanji/BRV) 中, 完美配合RecyclerView的缺省页和下拉刷新上拉加载. 

并且在网络请求中可以达到自动化显示和隐藏缺省页, 查看库 [Net](https://github.com/liangjingkanji/Net)

