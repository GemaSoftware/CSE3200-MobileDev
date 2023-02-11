package com.agrongemajli.cse3200_1_31_23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class SplashPage : AppCompatActivity() {

    private val launchButton: Button
        get() = findViewById(R.id.launch_button)

    private val greetingsText: TextView
        get() = findViewById(R.id.greetings_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_page)

        launchButton.setOnClickListener ( OnClickListener {
            Intent(this, MainActivity::class.java).also {
                it -> it.putExtra("AG", "Launched App");
                startActivity(it);
            }
             })
    }
}