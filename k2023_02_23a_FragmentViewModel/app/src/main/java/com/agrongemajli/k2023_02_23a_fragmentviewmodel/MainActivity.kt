package com.agrongemajli.k2023_02_23a_fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agrongemajli.k2023_02_23a_fragmentviewmodel.ui.main.TweetsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TweetsFragment.newInstance())
                .commitNow()
        }
    }
}