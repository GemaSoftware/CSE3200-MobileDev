package com.agrongemajli.cse3200_lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class quiz_end : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz_end, container, false)
        view.findViewById<TextView>(R.id.scoreNumber).text = arguments?.getInt("score").toString()
        return view
    }


}