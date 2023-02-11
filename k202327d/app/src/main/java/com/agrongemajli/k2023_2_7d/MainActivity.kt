package com.agrongemajli.k2023_2_7d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import com.agrongemajli.k2023_2_7d.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        activityMainBinding.toastButton.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this, "Toast!", Toast.LENGTH_SHORT).show()
            }
        )
    }
}