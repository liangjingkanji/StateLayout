<p align="center"><img src="https://i.loli.net/2021/08/14/kqTVfluhDo3tAHU.gif" width="30%"/></p>

StateLayout布局包裹的内容才能控制其显示缺省页

<br>

## 创建缺省页

创建缺省页支持两种方式

=== "布局声明"
    ```xml
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
=== "代码包裹"
    本方法不推荐使用, 建议在Xml布局中创建StateLayout, 可保持代码可读性且避免不必要的问题发生, 性能也更优, 请注意反复调用本方法会反复创建StateLayout导致发生问题
    ```kotlin
    stateCreate() // 该函数可以在 Activity/Fragment中使用, 或者 View.stateCreate()
    ```

> 比如ViewPager中的Fragment不能使用`stateCreate()`创建, 因为其ViewPager的视图容器无法被替换
<br>

## 设置缺省页

设置缺省页可以通过两种方式设置

=== "代码设置"
    ```kotlin
    state.apply {
        emptyLayout = R.layout.layout_empty // 配置空布局
        errorLayout = R.layout.layout_error // 配置错误布局
        loadingLayout = R.layout.layout_loading // 配置加载中布局
    }
    ```

=== "布局属性设置"
    ```xml hl_lines="5 6 7"
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
这些`show*()`函数都有一个Any参数, 可以传递任何对象到[生命周期](callback.md)中, 进行定制化展示不同的缺省页