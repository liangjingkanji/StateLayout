## StateLayout



简单配置状态布局(缺省页)



特点

 * 全局配置
 * 单例配置
 * 生命周期(可以加载动画或者处理事件)
 * 支持activity/fragment/view替换
 * 支持Java或者XML实现
 * 无网络情况下showLoading显示错误布局, 有网则显示加载中布局



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

```
implementation 'com.github.liangjingkanji:StateLayout:1.0.1'
```

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



### 单例状态配置

显示级别优先于全局状态配置

```kotlin
state = state().apply {
  emptyLayout = R.layout.layout_empty

  onError {
    // can retry request
  }
}
```



### 切换状态

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



### 工具类

在`StateUtils`文件中存在一系列基于Kotlin特性的工具函数



```kotlin
fun Activity.state(): StateLayout

fun Fragment.state(): StateLayout

fun View.state(): StateLayout 
```



后面我会介绍如何将缺省页整合进网络框架中, 根据网络请求结果进行自动化处理缺省页. 

