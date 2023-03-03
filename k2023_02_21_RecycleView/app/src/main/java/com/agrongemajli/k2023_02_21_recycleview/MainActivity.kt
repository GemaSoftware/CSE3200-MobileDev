package com.agrongemajli.k2023_02_21_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flowerList = DataSource(this).getFlowerList()

        for(f in flowerList){
            println(f)
        }
    }
}