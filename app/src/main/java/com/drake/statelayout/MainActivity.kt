package com.drake.statelayout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.drake.library.StateLayout
import com.drake.library.state

class MainActivity : AppCompatActivity() {

    lateinit var state: StateLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        state = state().apply {
            emptyLayout = R.layout.layout_empty

            onError {
                // can retry request
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> state.showLoading()
            R.id.menu_content -> state.showContent()
            R.id.menu_error -> state.showError()
            R.id.menu_empty -> state.showEmpty()
        }
        return true
    }
}
