package com.agrongemajli.cse3200_lab2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.agrongemajli.cse3200_lab2.databinding.FragmentMainQuizBinding


class main_quiz : Fragment() {

    private lateinit var fragment_view_binding: FragmentMainQuizBinding

    private val questions = listOf<Question>(
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, false),
        Question(R.string.question_4, true),
        Question(R.string.question_5, true),
    )

    private var currentIndex: Int = 0
    private var userScore: Int = 0;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentIndex = 0;
        userScore = 0;
        val view = inflater.inflate(R.layout.fragment_main_quiz, container, false)
        // Inflate the layout for this fragment
        //set up the question

        view.findViewById<TextView>(R.id.quizQuestion).setText(questions[currentIndex].questionResID)
        //we need to program checking for the right answer.
        view.findViewById<Button>(R.id.true_button).setOnClickListener (
            View.OnClickListener {
                Log.i("GemaSoftware", "clicked true")
                checkAnswer(true)
            }
        )
        view.findViewById<Button>(R.id.false_button).setOnClickListener(
            View.OnClickListener {
                Log.i("GemaSoftware", "clicked false")
                checkAnswer(false)
            }
        )
        return view
    }

    private fun checkAnswer(userAnswer: Boolean) {
        //get current question.
        Toast.makeText(requireActivity(), questions[currentIndex].questionResID, Toast.LENGTH_SHORT)
        Toast.makeText(requireActivity(), if(questions[currentIndex].answer == userAnswer){ userScore++; R.string.correct_message } else { R.string.incorrect_message },
            Toast.LENGTH_SHORT).show()
        updateScore()
        nextQuestion()
    }

    private fun updateScore() {
        view?.findViewById<TextView>(R.id.scoreNumber)?.text = userScore.toString()
    }

    private fun nextQuestion(){
        currentIndex++
        if(currentIndex < questions.size){
            //update question
            view?.findViewById<TextView>(R.id.quizQuestion)?.setText(questions[currentIndex].questionResID)
        } else {
            // if we reached end of questions
            //we want to update screen and say quiz over and just show score.
            val bundle = bundleOf("score" to userScore)
            findNavController().navigate(R.id.action_main_quiz_to_quiz_end, bundle)


        }
    }
}

