var __index = {"config":{"lang":["en"],"separator":"[\\s\\-,:!=\\[\\]()\"/]+|(?!\\b)(?=[A-Z][a-z])|\\.(?!\\d)|&[lg]t;","pipeline":["stemmer"]},"docs":[{"location":"index.html","title":"\u4f7f\u7528","text":"<p>\u7f3a\u7701\u9875\u5b58\u5728\u4e0d\u540c\u7684\u72b6\u6001, \u53ef\u4ee5\u79f0\u4e3a\u72b6\u6001\u9875, \u800cStateLayout\u5e03\u5c40\u5305\u88f9\u7684\u89c6\u56fe\u53eb\u5185\u5bb9\u89c6\u56fe</p> <p></p>"},{"location":"index.html#_1","title":"\u521b\u5efa\u7f3a\u7701\u9875","text":"<p>\u521b\u5efa\u7f3a\u7701\u9875\u652f\u6301\u4e24\u79cd\u65b9\u5f0f</p> \u5e03\u5c40\u58f0\u660e\u4ee3\u7801\u521b\u5efa <pre><code>&lt;com.drake.statelayout.StateLayout\nxmlns:app=\"http://schemas.android.com/apk/res-auto\"\nxmlns:tools=\"http://schemas.android.com/tools\"\nandroid:id=\"@+id/state\"\nandroid:layout_width=\"match_parent\"\nandroid:layout_height=\"match_parent\"\ntools:context=\"com.example.statelayout.MainActivity\"&gt;\n&lt;TextView\nandroid:id=\"@+id/tv_content\"\nandroid:layout_width=\"wrap_content\"\nandroid:layout_height=\"wrap_content\"\nandroid:layout_gravity=\"center\"\nandroid:text=\"\u52a0\u8f7d\u6210\u529f\" /&gt;\n&lt;/com.drake.statelayout.StateLayout&gt;\n</code></pre> <p>\u51fa\u4e8e\u6027\u80fd\u548c\u95ee\u9898\u8003\u8651\u4e0d\u63a8\u8350\u4f7f\u7528, \u53cd\u590d\u8c03\u7528\u672c\u65b9\u6cd5\u4f1a\u53cd\u590d\u521b\u5efaStateLayout\u5bfc\u81f4\u53d1\u751f\u95ee\u9898 <pre><code>stateCreate() // \u53ef\u5728 Activity/Fragment/View \u4e2d\u4f7f\u7528\n</code></pre></p> <p></p>"},{"location":"index.html#_2","title":"\u914d\u7f6e\u7f3a\u7701\u9875","text":"<p>\u6307\u5b9a\u72b6\u6001\u9875\u53ef\u4ee5\u4e24\u79cd\u65b9\u5f0f</p> \u4ee3\u7801\u914d\u7f6e\u5e03\u5c40\u914d\u7f6e <pre><code>state.apply {\nemptyLayout = R.layout.layout_empty // \u914d\u7f6e\u7a7a\u5e03\u5c40\nerrorLayout = R.layout.layout_error // \u914d\u7f6e\u9519\u8bef\u5e03\u5c40\nloadingLayout = R.layout.layout_loading // \u914d\u7f6e\u52a0\u8f7d\u4e2d\u5e03\u5c40\n}\n</code></pre> <pre><code>&lt;com.drake.statelayout.StateLayout\nxmlns:app=\"http://schemas.android.com/apk/res-auto\"\nxmlns:tools=\"http://schemas.android.com/tools\"\nandroid:id=\"@+id/state\"\napp:empty_layout=\"@layout/layout_empty\"\napp:error_layout=\"@layout/layout_error\"\napp:loading_layout=\"@layout/layout_loading\"\nandroid:layout_width=\"match_parent\"\nandroid:layout_height=\"match_parent\"\ntools:context=\"com.example.statelayout.MainActivity\"&gt;\n&lt;TextView\nandroid:id=\"@+id/tv_content\"\nandroid:layout_width=\"wrap_content\"\nandroid:layout_height=\"wrap_content\"\nandroid:layout_gravity=\"center\"\nandroid:text=\"\u52a0\u8f7d\u6210\u529f\" /&gt;\n&lt;/com.drake.statelayout.StateLayout&gt;\n</code></pre>"},{"location":"index.html#_3","title":"\u663e\u793a\u7f3a\u7701\u9875","text":"<p><pre><code>state.showLoading()\nstate.showEmpty()\nstate.showError()\nstate.showContent()\n</code></pre> <code>showXX()</code>\u90fd\u6709\u4e00\u4e2aAny\u53c2\u6570(\u6807\u7b7e), \u53ef\u4ee5\u4f20\u9012\u5bf9\u8c61\u5230\u751f\u547d\u5468\u671f\u4e2d, \u8fdb\u884c\u5b9a\u5236\u5316\u5c55\u793a</p>"},{"location":"animation.html","title":"\u52a8\u753b","text":"<p>\u5728\u751f\u547d\u5468\u671f\u4e2d\u83b7\u53d6\u89c6\u56fe\u6dfb\u52a0\u81ea\u5b9a\u4e49\u52a8\u753b</p> <p>\u52a8\u753b\u7f3a\u70b9</p> <p>\u8fc7\u5ea6\u4f7f\u7528\u52a8\u753b\u4f1a\u62d6\u6162\u54cd\u5e94\u901f\u5ea6, \u7528\u6237\u4f7f\u7528\u4f53\u9a8c\u53ef\u80fd\u4e0d\u592a\u597d</p>"},{"location":"animation.html#_1","title":"\u7f3a\u7701\u9875\u663e\u793a\u52a8\u753b","text":"<p>\u4ee5\u4e0b\u4e3a\u7f3a\u7701\u9875\u6e10\u53d8\u52a8\u753b\u6f14\u793a</p> <p></p> <ol> <li> <p>\u4e3a\u907f\u514d\u91cd\u590d\u4ee3\u7801\u9996\u5148\u521b\u5efa\u7edf\u4e00\u7684\u52a8\u753b\u51fd\u6570</p> <pre><code>private fun View.startAnimation() {\n// \u5148\u5c06\u89c6\u56fe\u9690\u85cf\u7136\u540e\u5728800\u6beb\u79d2\u5185\u6e10\u53d8\u663e\u793a\u89c6\u56fe\nanimate().setDuration(0).alpha(0F).withEndAction {\nanimate().setDuration(800).alpha(1F)\n}\n}\n</code></pre> </li> <li> <p>\u7136\u540e\u4e3a\u6bcf\u4e2a\u7f3a\u7701\u9875\u8bbe\u7f6e\u52a8\u753b</p> <pre><code>StateConfig.apply {\nonError {\nstartAnimation()\n}\nonEmpty {\nstartAnimation()\n}\nonContent {\nstartAnimation()\n}\nonLoading {\nstartAnimation()\n}\n}\n</code></pre> <p>\u5f53\u7136\u4e5f\u53ef\u4ee5\u4ec5\u8bbe\u7f6e\u4f60\u6307\u5b9a\u7684\u7f3a\u7701\u9875\u52a8\u753b</p> </li> </ol>"},{"location":"animation.html#_2","title":"\u7f3a\u7701\u9875\u5207\u6362\u52a8\u753b","text":"<p>\u5982\u679c\u9700\u8981\u5904\u7406\u524d\u4e00\u4e2a\u72b6\u6001\u7684\u9690\u85cf\u4ee5\u53ca\u65b0\u7684\u72b6\u6001\u7684\u663e\u793a, \u90a3\u4e48\u5c31\u5f97\u5b9e\u73b0\u63a5\u53e3<code>StateChangedHandler</code>\u81ea\u5b9a\u4e49\u5904\u7406</p> <p>\u6846\u67b6\u81ea\u5e26\u4e00\u4e2a\u6e10\u53d8\u900f\u660e<code>FadeStateChangedHandler</code></p> \u53c2\u8003\u6e90\u7801 FadeStateChangedHandler.kt <pre><code>/**\n * \u5207\u6362\u72b6\u6001\u65f6\u4f7f\u7528\u6e10\u53d8\u900f\u660e\u52a8\u753b\u8fc7\u6e21\n * @param duration \u52a8\u753b\u6267\u884c\u65f6\u95f4\n */\nopen class FadeStateChangedHandler(var duration: Long = 400) : StateChangedHandler {\nprivate var stateLayout: WeakReference&lt;StateLayout&gt; = WeakReference(null)\n/**\n     * StateLayout\u5220\u9664\u7f3a\u7701\u9875, \u6b64\u65b9\u6cd5\u6bd4[onAdd]\u5148\u6267\u884c\n     * @param container StateLayout\n     * @param state \u5c06\u88ab\u5220\u9664\u7f3a\u7701\u9875\u89c6\u56fe\u5bf9\u8c61\n     * @param status \u5f53\u524d\u72b6\u6001\n     * @param tag \u663e\u793a\u72b6\u6001\u4f20\u5165\u7684tag\n     */\noverride fun onRemove(container: StateLayout, state: View, status: Status, tag: Any?) {\nif (container != stateLayout.get() &amp;&amp; status == Status.LOADING) {\nreturn super.onRemove(container, state, status, tag)\n}\nstate.animate().setDuration(duration).alpha(0f).setListener(object : AnimatorListenerAdapter() {\noverride fun onAnimationEnd(animation: Animator) {\n// \u7b49\u5f85\u52a8\u753b\u6267\u884c\u5b8c\u6bd5\u540e\u5220\u9664\u65e7\u7684\u7f3a\u7701\u9875\u89c6\u56fe\nStateChangedHandler.onRemove(container, state, status, tag)\n}\n}).start()\n}\n/**\n     * StateLayout\u6dfb\u52a0\u7f3a\u7701\u9875\n     * @param container StateLayout\n     * @param state \u5c06\u88ab\u6dfb\u52a0\u7f3a\u7701\u9875\u89c6\u56fe\u5bf9\u8c61\n     * @param status \u5f53\u524d\u72b6\u6001\n     * @param tag \u663e\u793a\u72b6\u6001\u4f20\u5165\u7684tag\n     */\noverride fun onAdd(container: StateLayout, state: View, status: Status, tag: Any?) {\n// \u521d\u6b21\u52a0\u8f7d\u4e0d\u5e94\u7528\u52a8\u753b\nif (container != stateLayout.get() &amp;&amp; status == Status.LOADING) {\nstateLayout = WeakReference(container)\nreturn StateChangedHandler.onAdd(container, state, status, tag)\n}\nsuper.onAdd(container, state, status, tag)\nstate.alpha = 0f\nstate.animate().setDuration(duration).alpha(1f).start()\n}\n}\n</code></pre> <p>\u53ef\u4ee5\u5168\u5c40/\u5355\u4f8b\u914d\u7f6e</p> <pre><code>StateConfig.stateChangedHandler = StateChangedHandler()\n</code></pre>"},{"location":"callback.html","title":"\u751f\u547d\u5468\u671f","text":"<p>\u751f\u547d\u5468\u671f\u56de\u8c03\u4e2d\u53ef\u4ee5\u83b7\u53d6\u72b6\u6001\u53c2\u6570/\u89c6\u56fe\u5bf9\u8c61</p> \u51fd\u6570 \u63cf\u8ff0 onEmpty showEmpty \u65f6\u56de\u8c03 onError showError \u65f6\u56de\u8c03 onContent showContent \u65f6\u56de\u8c03 onLoading showLoading \u65f6\u56de\u8c03 onRefresh showLoading \u65f6\u56de\u8c03, \u4e00\u822c\u5728\u5176\u4e2d\u6267\u884c\u52a0\u8f7d\u7f51\u7edc\u5f02\u6b65\u4efb\u52a1 stateChangedHandler \u5b8c\u5168\u63a5\u7ba1\u7f3a\u7701\u9875\u72b6\u6001\u53d8\u66f4\u65f6\u5904\u7406"},{"location":"callback.html#_1","title":"\u76d1\u542c\u7f3a\u7701\u9875\u663e\u793a","text":"<pre><code>state.onRefresh {\n// \u6267\u884c\u8bf7\u6c42\n}.showLoading()\n</code></pre> <p>\u76d1\u542c\u7f3a\u7701\u9875\u663e\u793a</p> <pre><code>state.onEmpty {\n}.onError {\n}.onLoading {\n}.onRefresh {\n}\n</code></pre> <p><code>onRefresh</code>\u548c<code>onLoading</code>\u89e6\u53d1\u6761\u4ef6\u76f8\u540c, \u4f46\u662f\u53c2\u6570\u4e0d\u540c, \u4ed6\u4eec\u6240\u4ee3\u8868\u7684\u7684\u4f5c\u7528\u4e5f\u4e0d\u540c</p> <ol> <li><code>onRefresh</code> \u4e2d\u5e38\u89c1\u5904\u7406\u7f51\u7edc\u8bf7\u6c42\u5f02\u6b65\u4efb\u52a1</li> <li><code>onLoading</code> \u4e2d\u5e38\u89c1\u5904\u7406\u7684\u662f\u52a0\u8f7d\u89c6\u56fe/\u52a8\u753b</li> </ol>"},{"location":"callback.html#_2","title":"\u5b8c\u5168\u81ea\u5b9a\u4e49","text":"<p>\u5b9e\u73b0<code>StateChangedHandler</code>\u53ef\u4ee5\u5b9e\u73b0\u6700\u5927\u7a0b\u5ea6\u81ea\u5b9a\u4e49</p> <p>\u751a\u81f3\u6765\u53d6\u4ee3\u9ed8\u8ba4\u7684\u7f3a\u7701\u9875\u5207\u6362\u903b\u8f91, \u53ef\u4ee5\u81ea\u5b9a\u4e49\u7f3a\u7701\u9875\u663e\u793a/\u9690\u85cf\u52a8\u753b, \u5e76\u4e14\u53ef\u4ee5\u81ea\u5b9a\u4e49\u5e03\u5c40\u53c2\u6570(\u5bbd\u9ad8)</p> <pre><code>// \u5355\u4f8b\nstate.stateChangedHandler = StateChangedHandler()\n// \u5168\u5c40\nStateConfig.stateChangedHandler = StateChangedHandler()\n</code></pre> <p>StateChangedHandler\u9ed8\u8ba4\u662fremoveView/addView, \u5982\u679c\u4f60\u60f3\u6539\u6210visibility\u5c31\u8bf7\u81ea\u5b9a\u4e49</p>"},{"location":"config.html","title":"\u5168\u5c40\u914d\u7f6e","text":"<p>\u5728Application\u4e2d\u53ef\u4ee5\u4f7f\u7528StateConfig\u8fdb\u884c\u521d\u59cb\u5316\u914d\u7f6e</p> <pre><code>StateConfig.apply {\nemptyLayout = R.layout.layout_empty\nerrorLayout = R.layout.layout_error\nloadingLayout = R.layout.layout_loading\nsetRetryIds(R.id.msg) // \u5168\u5c40\u7684\u91cd\u8bd5Id\nonLoading {\n}\nonEmpty {\n}\nonError {\n}\n}\n</code></pre>"},{"location":"issues.html","title":"\u5e38\u89c1\u95ee\u9898","text":"<ol> <li>\u5728Coordinator\u4e2d\u4f7f\u7528\u65e0\u6cd5\u6eda\u52a8</li> <li>\u6211\u5982\u4f55\u5b9a\u4e49\u4e0d\u540c\u72b6\u6001\u7684\u7f3a\u7701\u9875\u6765\u663e\u793a</li> <li>\u5c4f\u5e55\u65cb\u8f6c\uff0c\u62a5ID\u91cd\u590d\u5f02\u5e38</li> </ol>"},{"location":"multi-state.html","title":"\u591a\u72b6\u6001","text":"<p>StateLayout\u53ea\u5305\u542b\u56db\u79cd\u72b6\u6001</p> <ol> <li>\u9519\u8bef\u72b6\u6001</li> <li>\u7a7a\u72b6\u6001</li> <li>\u52a0\u8f7d\u4e2d\u72b6\u6001</li> <li>\u5185\u5bb9(StateLayout\u5305\u88f9\u7684\u89c6\u56fe)</li> </ol> <p> \u5982\u679c\u9700\u8981\u65b0\u589e\u4e00\u79cd\u72b6\u6001, \u4f8b\u5982\u9519\u8bef\u5206\u4e3a\u7f51\u7edc/\u4e1a\u52a1\u9519\u8bef, \u53ef\u4ee5\u4f7f\u7528<code>\u6807\u7b7e(tag)</code>\u6765\u533a\u5206\u5904\u7406</p>"},{"location":"multi-state.html#_1","title":"\u793a\u4f8b","text":"<p>\u4f20\u9012\u6807\u7b7e <pre><code>showError(NetNetworkingException()) // \u4f20\u9012\u5f02\u5e38\u5bf9\u8c61\u4f5c\u4e3a\u6807\u7b7e\n</code></pre></p> <p>\u914d\u7f6e\u5168\u5c40\u89c6\u56fe\u56de\u8c03</p> <pre><code>StateConfig.onError {\nif (it is NetNetworkingException) {\n// \u4e3a\u65e0\u7f51\u7edc\u5f02\u5e38\u5c55\u793a\u4e0d\u540c\u56fe\u7247, \u5f53\u7136\u4f60\u4e5f\u53ef\u4ee5addView\nfindViewById&lt;View&gt;(R.id.iv_error).setImageResource(R.drawable.ic_networking_error)\n}\n}\n</code></pre> <p>\u66f4\u591a\u81ea\u5b9a\u4e49\u8bf7\u89c1 StateChangedHandler</p>"},{"location":"retry.html","title":"\u70b9\u51fb\u91cd\u8bd5","text":"<p>\u5728\u9519\u8bef/\u7a7a\u72b6\u6001\u53ef\u4ee5\u70b9\u51fb\u56fe\u7247\u6216\u6309\u94ae\u8fdb\u884c\u91cd\u65b0\u4eb2\u621a</p>"},{"location":"retry.html#_1","title":"\u5feb\u901f\u914d\u7f6e","text":"<p>\u539f\u7406</p> <p>\u70b9\u51fb\u4f60\u4f20\u5165\u7684\u63a7\u4ef6ID\u540e\u81ea\u52a8\u8c03\u7528<code>showLoading()</code>, \u652f\u6301\u9519\u8bef/\u7a7a\u4e24\u79cd\u72b6\u6001</p> \u5355\u4f8b\u5168\u5c40 <pre><code>state.setRetryIds(R.id.msg)\n</code></pre> <pre><code>StateConfig.setRetryIds(R.id.msg)\n</code></pre>"},{"location":"retry.html#_2","title":"\u81ea\u5b9a\u4e49\u91cd\u8bd5","text":"<p>\u53ef\u4ee5\u81ea\u5df1\u5728\u751f\u547d\u5468\u671f\u56de\u8c03\u4e2d\u4e3aView\u8bbe\u7f6e\u70b9\u51fb\u4e8b\u4ef6</p> <pre><code>binding.state.onError {\nfindViewById&lt;View&gt;(R.id.image).setOnClickListener {\nbinding.state.showLoading()\n}\n}\n</code></pre> <p>\u66f4\u591a\u81ea\u5b9a\u4e49\u8bf7\u89c1\u751f\u547d\u5468\u671f</p>"},{"location":"skeleton.html","title":"\u9aa8\u9abc\u52a8\u753b","text":"<p>\u9aa8\u9abc\u52a8\u753b\u53ea\u662f\u4e00\u79cd\u52a0\u8f7d\u4e2d\u72b6\u6001\u52a8\u753b</p> <p>\u4e00\u822c\u4f7f\u7528\u8bbe\u8ba1\u5e08\u63d0\u4f9b\u7684\u52a8\u753b\u6587\u4ef6(\u6216Gif\u56fe), \u6bd4\u5982\u5e38\u7528\u7684Lottie\u5c31\u652f\u6301\u521b\u5efa\u9aa8\u9abc\u52a8\u753b</p> <p>\u5728\u793a\u4f8b\u9879\u76ee\u4e2d\u63d0\u4f9b\u81ea\u5b9a\u4e49<code>LeastAnimationStateChangedHandler</code>\u6765\u5b9e\u73b0\u9aa8\u9abc\u52a8\u753b, \u89e3\u51b3\u4ee5\u4e0b\u95ee\u9898</p> <p>\u5b9e\u73b0\u539f\u7406</p> <p>\u5b9e\u9645\u4e0a\u505a\u7684\u4e8b\u5f88\u7b80\u5355, \u4e5f\u5c31\u662f\u4fdd\u8bc1\u52a8\u753b\u6700\u77ed\u6267\u884c\u65f6\u95f4, \u907f\u514d\u8bf7\u6c42\u8fc7\u5feb\u5bfc\u81f4\u9aa8\u9abc\u52a8\u753b\u4e00\u95ea\u800c\u8fc7</p> <p>\u9aa8\u9abc\u52a8\u753b\u793a\u4f8b</p>"},{"location":"tag.html","title":"\u6807\u7b7e","text":"<p><code>showXX()</code>\u51fd\u6570\u663e\u793a\u7f3a\u7701\u9875\u65f6\u4f20\u5165\u53c2\u6570<code>tag</code>, \u5728<code>onXX()</code>\u56de\u8c03\u4e2d\u63a5\u6536<code>tag</code>\u5e76\u5904\u7406</p>"},{"location":"tag.html#_1","title":"\u4f7f\u7528","text":"<p>\u4f8b\u5982\u6839\u636e\u4e0d\u540c\u72b6\u6001\u7801, \u670d\u52a1\u5668\u5f02\u5e38500/\u8bf7\u6c42\u53c2\u6570\u9519\u8bef400 \u533a\u5206\u63d0\u793a\u6587\u5b57</p> <ol> <li>400 \u663e\u793a \u9519\u8bef\u7801/\u9519\u8bef\u4fe1\u606f</li> <li>500 \u663e\u793a \"\u65e0\u6cd5\u627e\u5230\u670d\u52a1\u5668\"</li> </ol> <pre><code>state.showError(ResponseException(code = 403, msg = \"\u8bf7\u6c42\u53c2\u6570\u9519\u8bef\"))\n</code></pre> \u5355\u4f8b\u9519\u8bef\u76d1\u542c\u5168\u5c40\u9519\u8bef\u76d1\u542c <pre><code>state.onError {\nif (it is ResponseException) {\nfindViewById&lt;TextView&gt;.text = \"\u9519\u8bef\u7801: ${it.code}, \u9519\u8bef\u4fe1\u606f: ${it.msg}\"\n}\n}\n</code></pre> <pre><code>StateConfig.onError {\nif (it is ResponseException) {\nfindViewById&lt;TextView&gt;.text = \"\u9519\u8bef\u7801: ${it.code}, \u9519\u8bef\u4fe1\u606f: ${it.msg}\"\n}\n}\n</code></pre>"}]}