package com.applicat.listapp

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(
    private val dataSet: MutableList<ModelOfFilm>,
    private val itemClickListener: (position: Int) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.NameTv)
        val textViewGenre: TextView = view.findViewById(R.id.GenreTv)
        val image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewGenre.text = "Genre:${dataSet[position].genre}"
        viewHolder.textViewName.text = "Name:${dataSet[position].name}"
        Log.d("sdasdafvczx","what")
        Glide.with(context)
            .load(dataSet[position].image)
            .circleCrop()
            .into(viewHolder.image)
        // Set click listener
        viewHolder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }
    }

    override fun getItemCount() = dataSet.size
}