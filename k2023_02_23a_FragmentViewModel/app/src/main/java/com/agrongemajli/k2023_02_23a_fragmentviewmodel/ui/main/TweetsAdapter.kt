package com.agrongemajli.k2023_02_23a_fragmentviewmodel.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.agrongemajli.k2023_02_23a_fragmentviewmodel.R

class TweetsAdapter(private val tweets: Array<String>) : RecyclerView.Adapter<TweetsAdapter.TweetHolder>() {

    class TweetHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tweetTextView: TextView = itemView.findViewById(R.id.tweet_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tweet_layout, parent, false)
        return TweetHolder(view)
    }

    override fun onBindViewHolder(holder: TweetHolder, position: Int) {
        holder.tweetTextView.text = tweets[position]
    }

    override fun getItemCount() = tweets.size

}
