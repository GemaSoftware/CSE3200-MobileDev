package com.agrongemajli.cse3200_1_31_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val greeting_message: TextView
        get() = findViewById(R.id.hello_message)

    private val update_button: Button
        get() = findViewById(R.id.update_greeting)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        update_button.setOnClickListener( View.OnClickListener {
            var updateString: String? = intent.getStringExtra("AG")
            greeting_message.text = updateString
        })
    }


}