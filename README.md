## StateLayout

<p align="center"><img src="https://i.imgur.com/WtX3k3C.png" alt="1600" width="30%"/></p> <br>

<p align="center"><strong>整个应用的缺省页</strong></p><br>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/StateLayout"><img src="https://jitpack.io/v/liangjingkanji/StateLayout.svg"/></a>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>


<p align="center"><a href="http://liangjingkanji.github.io/StateLayout/">使用文档</a></p>



<p align="center"><img src="https://i.imgur.com/2pry0ft.png" alt="image-20200802050745439" width="40%" /></p>

### 功能

- [x] 布局和代码都可以声明
- [x] Fragment/Activity/View/ConstraintLayout/RecyclerView都支持
- [x] 无网络情况下`showLoading`直接显示错误布局, 有网则显示`loadingLayout`
- [x] 异步线程调用
- [x] 默认缺省页(全局)
- [x] 指定缺省页(单例)
- [x] 缺省页生命周期
- [x] 刷新回调
- [x] 传递标签
- [x] 配合列表使用自动化显示列表缺省页
- [x] 配合网络请求自动化显示缺省页



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
implementation 'com.github.liangjingkanji:StateLayout:1.0.12'
```



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

