/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：StateLayout
 * Author：drake
 * Date：7/14/20 2:23 PM
 */

package com.example.statelayout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.drake.statelayout.StateLayout
import com.drake.statelayout.state
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var state: StateLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        state = state()
        state.onRefresh {
            // 一般在这里进行网络请求
            thread {
                Thread.sleep(2000)
            }
        }.showLoading()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> state.showLoading()
            R.id.menu_content -> state.showContent()
            R.id.menu_error -> state.showError(NullPointerException())
            R.id.menu_empty -> state.showEmpty()
        }
        return true
    }
}
