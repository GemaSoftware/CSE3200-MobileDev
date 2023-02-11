package com.agrongemajli.cse3200_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agrongemajli.cse3200_lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the Layout Binding.
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //Set Main Content View to the root binding.
        setContentView(activityMainBinding.root)
    }

}