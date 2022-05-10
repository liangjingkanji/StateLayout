## StateLayout

<p align="center"><img src="https://i.imgur.com/WtX3k3C.png" alt="1600" width="30%"/></p> <br>

<p align="center"><strong>整个应用的缺省页</strong></p><br>

<p align="center"><a href="http://liangjingkanji.github.io/StateLayout/">使用文档</a> | <a href="https://statelayout-1252757332.cos-website.ap-guangzhou.myqcloud.com">备用访问</a></p>

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

- 扩展性强
- 代码少
- 完善的文档和长期维护
- 提供网络请求和列表框架实现自动化, 代码编写过程中无需关注缺省页显示

### 功能

- [x] 全部/局部缺省页
- [x] 布局或代码声明皆可
- [x] 全局/单例配置
- [x] 监听缺省页显示
- [x] 完全自己处理缺省页切换
- [x] 自定义缺省页动画
- [x] 动态配置缺省页布局参数
- [x] 配置点击重试
- [x] 异步线程
- [x] 传递标签细化缺省状态
- [x] 网络请求回调
- [x] 无网络立即显示错误缺省页
- [x] 配合列表使用自动化显示列表缺省页
- [x] 配合网络请求自动化显示缺省页

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
implementation 'com.github.liangjingkanji:StateLayout:1.2.0'
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

