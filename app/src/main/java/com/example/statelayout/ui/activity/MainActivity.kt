/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.statelayout.ui.activity

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.drake.engine.base.EngineActivity
import com.example.statelayout.R
import com.example.statelayout.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : EngineActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        binding.state.onRefresh {
            // 一般这里进行网络请求, 推荐使用 https://github.com/liangjingkanji/Net
            thread {
                Thread.sleep(2000)
                showContent()
            }
        }.showLoading()
    }

    override fun initData() {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> binding.state.showLoading()
            R.id.menu_content -> binding.state.showContent()
            R.id.menu_error -> binding.state.showError(NullPointerException())
            R.id.menu_empty -> binding.state.showEmpty()
            R.id.menu_skeleton -> startActivity(Intent(this, SkeletonAnimationActivity::class.java))
        }
        return true
    }
}
