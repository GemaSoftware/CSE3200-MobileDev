package com.agrongemajli.k2023_02_23a_fragmentviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agrongemajli.k2023_02_23a_fragmentviewmodel.R

class TweetsFragment : Fragment() {

    companion object {
        fun newInstance() = TweetsFragment()
    }

    private lateinit var tweetViewModel: TweetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tweetViewModel = ViewModelProvider(this).get(TweetViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        // Initialize the ViewModel
        tweetViewModel = ViewModelProvider(this).get(TweetViewModel::class.java)

        // Get the RecyclerView from the layout
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.tweets_recycler_view)

        // Set up the RecyclerView with a LinearLayoutManager and the adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TweetsAdapter(tweetViewModel.tweets)

        return rootView




    }

}