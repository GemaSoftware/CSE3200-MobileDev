package com.agrongemajli.lab4_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agrongemajli.lab4_recycleview.ui.main.TweetsFragment

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