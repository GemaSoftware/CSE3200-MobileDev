package com.agrongemajli.cse3200_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agrongemajli.cse3200_lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding;

    private val questions = listOf<Question>(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, false),
        Question(R.string.question_4, true),
        Question(R.string.question_5, true),
    )

    private var currentIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the Layout Binding.
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //Set Main Content View to the root binding.
        setContentView(activityMainBinding.root)
    }

}