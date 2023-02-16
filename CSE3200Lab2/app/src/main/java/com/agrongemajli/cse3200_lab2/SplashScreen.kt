package com.agrongemajli.cse3200_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.agrongemajli.cse3200_lab2.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var splashScreenBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)

        splashScreenBinding.startQuizButton.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        )

        setContentView(splashScreenBinding.root)

    }
}