package com.example.musikupedia.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.R

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val jenis = arrayOf("Judul 1", "Judul 2", "Judul 3", "Judul 4", "Judul 1", "Judul 2", "Judul 3", "Judul 4", "Judul 1", "Judul 2", "Judul 3", "Judul 4")
    private val cover = arrayOf(R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis, R.drawable.jenis)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var jenis: TextView
        var cover: ImageView

        init {
            jenis = itemView.findViewById(R.id.jenis)
            cover = itemView.findViewById(R.id.imageJenis)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_search, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jenis.text = jenis[position]
        holder.cover.setImageResource(cover[position])
    }

    override fun getItemCount(): Int {
        return jenis.count()
    }
}