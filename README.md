## StateLayout

<p align="center"><img src="https://i.imgur.com/WtX3k3C.png" alt="1600" width="30%"/></p> <br>

<p align="center"><strong>整个应用的缺省页</strong></p><br>

<p align="center">
<a href="http://liangjingkanji.github.io/StateLayout/">使用文档</a>
| <a href="https://statelayout-1252757332.cos-website.ap-guangzhou.myqcloud.com">备用访问</a>
| <a href="https://github.com/liangjingkanji/StateLayout/releases/download/1.3.6/state-layout-sample.apk">下载体验</a>
</p>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/StateLayout"><img src="https://jitpack.io/v/liangjingkanji/StateLayout.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://liangjingkanji.github.io/StateLayout/api/"><img src="https://img.shields.io/badge/api-%E5%87%BD%E6%95%B0%E6%96%87%E6%A1%A3-red"/></a>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>

<p align="center"><img src="https://i.imgur.com/YmP9RKB.gif" alt="image-20200802050745439" width="40%" /></p>

<br>

### 优势

- [x] 高扩展性
- [x] 使用简单
- [x] 详细的文档
- [x] 长期维护
- [x] 可选网络/列表框架配合实现自动化, 开发过程中基本上无需处理缺省页切换

### 功能

- [x] 全局/局部缺省页
- [x] 布局或代码声明
- [x] 全局/单例配置
- [x] 快速配置点击重试
- [x] 监听缺省页回调
- [x] 自定义动画/布局
- [x] [骨骼动画](https://github.com/liangjingkanji/StateLayout/blob/14fb37bbafc7f45000e03199fa8b8c597b364755/app/src/main/java/com/example/statelayout/handler/LeastAnimationStateChangedHandler.kt)
- [x] 传递标签
- [x] 自定义缺省页切换处理
- [x] 异步线程使用
- [x] 配合[BRV](https://github.com/liangjingkanji/BRV/)使用自动化显示列表缺省页 (可选)
- [x] 配合[Net](https://github.com/liangjingkanji/Net/)网络请求自动化显示缺省页 (可选)

<br>

## 安装

添加远程仓库根据创建项目的 Android Studio 版本有所不同

Android Studio Arctic Fox以下创建的项目 在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

Android Studio Arctic Fox以上创建的项目 在项目根目录的 settings.gradle 添加仓库

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

然后在 module 的 build.gradle 添加依赖框架

```groovy
implementation 'com.github.liangjingkanji:StateLayout:1.3.6'
```

<br>

## License

```
Copyright (C) 2018 Drake, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

