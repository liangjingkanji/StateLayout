
<img src='https://i.imgur.com/YW7EzWh.gif' width="50%"/>

首先明确的就是StateLayout布局包裹的内容才能控制其显示缺省页, 所以在我们创建缺省页的时候一定要包裹住一个内容作为内容页面

<br>

1. StateLayout继承自FrameLayout
1. StateLayout不能通过代码包裹ViewPager中的Fragment, 因为其ViewPager的视图容器无法被替换
<br>

## 创建缺省页

创建缺省页支持两种方式.
Activity/Fragment/View都可以使用函数`state`来创建StateLayout, 代码创建属于`addView`的替换视图对象的原理, 其过度使用可能容易造成视图参数丢失, 不推荐频繁使用.

推荐在布局中创建缺省页

```kotlin tab="代码包裹"
state() // 该函数可以在 Activity/Fragment中使用, 或者 View.state()
```

```xml tab="布局声明"
<com.drake.statelayout.StateLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/state"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.statelayout.MainActivity">

    <TextView
        android:id="@+id/tv_content"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="加载成功" />

</com.drake.statelayout.StateLayout>
```

TextView即我们假设的内容页

<br>

## 设置缺省页

设置缺省页可以通过两种方式设置

```kotlin tab="代码设置"
state.apply {
    emptyLayout = R.layout.layout_empty // 配置空布局
    errorLayout = R.layout.layout_error // 配置错误布局
    loadingLayout = R.layout.layout_loading // 配置加载中布局
}
```

```kotlin tab="布局属性设置" hl_lines="5 6 7"
<com.drake.statelayout.StateLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/state"
    app:empty_layout="@layout/layout_empty"
    app:error_layout="@layout/layout_error"
    app:loading_layout="@layout/layout_loading"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.statelayout.MainActivity">

    <TextView
        android:id="@+id/tv_content"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="加载成功" />

</com.drake.statelayout.StateLayout>
```

## 显示缺省页

```kotlin
state.showLoading()
state.showEmpty()
state.showError()
state.showContent()
```