package com.agrongemajli.lab5_radio_ag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RadioStationAdapter(
    private val stations: List<RadioStation>,
    private val onItemClick: (RadioStation) -> Unit
) : RecyclerView.Adapter<RadioStationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val station = stations[position]
        holder.bind(station)
        holder.itemView.setOnClickListener { onItemClick(station) }
    }

    override fun getItemCount(): Int = stations.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.station_name_textview)
        private val imageView: ImageView = itemView.findViewById(R.id.station_imageview)

        fun bind(station: RadioStation) {
            nameTextView.text = station.name
            Glide.with(itemView.context).load(station.imageUrl).into(imageView)
        }
    }
}
