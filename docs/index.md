<p align="center"><img src="https://i.loli.net/2021/08/14/kqTVfluhDo3tAHU.gif" width="30%"/></p>

缺省页存在不同的状态, 可以称为状态页, 而StateLayout布局包裹的视图叫内容视图

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
=== "代码创建"
    出于性能和问题考虑不推荐使用, 反复调用本方法会反复创建StateLayout导致发生问题
    ```kotlin
    stateCreate() // 可在 Activity/Fragment/View 中使用
    ```

<br>

## 配置缺省页

指定状态页可以两种方式

=== "代码配置"
    ```kotlin
    state.apply {
        emptyLayout = R.layout.layout_empty // 配置空布局
        errorLayout = R.layout.layout_error // 配置错误布局
        loadingLayout = R.layout.layout_loading // 配置加载中布局
    }
    ```

=== "布局配置"
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
`showXX()`都有一个Any参数(标签), 可以传递对象到[生命周期](callback.md)中, 进行定制化展示