package com.agrongemajli.lab4_recycleview.ui.main

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agrongemajli.lab4_recycleview.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class TweetsAdapter(private val tweets: Array<String>, private val imageURLs: Array<String>) : RecyclerView.Adapter<TweetsAdapter.TweetHolder>() {

    class TweetHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tweetTextView: TextView = itemView.findViewById(R.id.tweet_text_view)
        val tweetImageView: ImageView = itemView.findViewById(R.id.tweetImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tweet_layout, parent, false)
        return TweetHolder(view)
    }

    override fun onBindViewHolder(holder: TweetHolder, position: Int) {
        holder.tweetTextView.text = tweets[position]
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val bitmap = withContext(Dispatchers.IO) {
                    Log.i("LOADINGURL", imageURLs[position])
                    val connection = URL(imageURLs[position]).openConnection() as HttpURLConnection
                    connection.connect()
                    val inputStream = connection.inputStream
                    BitmapFactory.decodeStream(inputStream)
                }
                holder.tweetImageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                // Handle any errors
            }
        }
    }

    override fun getItemCount() = tweets.size

}
