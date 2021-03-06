## StateLayout

<p align="center"><img src="https://i.imgur.com/WtX3k3C.png" alt="1600" width="30%"/></p> <br>

<p align="center"><strong>整个应用的缺省页</strong></p><br>

<p align="center"><a href="http://liangjingkanji.github.io/StateLayout/">使用文档</a> | <a href="https://coding-pages-bucket-3558162-8706000-16647-587725-1252757332.cos-website.ap-shanghai.myqcloud.com/">备用访问</a></p>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/StateLayout"><img src="https://jitpack.io/v/liangjingkanji/StateLayout.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://liangjingkanji.github.io/StateLayout/api/"><img src="https://img.shields.io/badge/api-%E5%87%BD%E6%95%B0%E6%96%87%E6%A1%A3-red"/></a>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>

<p align="center"><img src="https://i.imgur.com/YmP9RKB.gif" alt="image-20200802050745439" width="40%" /></p>

<br>

### 功能

- [x] 布局和代码创建缺省页
- [x] Fragment/Activity/View/ConstraintLayout/RecyclerView 支持函数包裹
- [x] 全局/单例缺省页
- [x] 缺省页生命周期
- [x] 加载任务回调
- [x] 传递标签
- [x] 点击重试
- [x] 支持异步线程
- [x] 无网络情况下立即显示错误页面
- [x] Kotlin特性
- [x] 配合列表使用自动化显示列表缺省页
- [x] 配合网络请求自动化显示缺省页

<br>

## 安装

在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

在 module 的 build.gradle 添加依赖

```groovy
implementation 'com.github.liangjingkanji:StateLayout:1.0.14'
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

