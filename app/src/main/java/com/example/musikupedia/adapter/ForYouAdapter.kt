package com.example.musikupedia.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.R

class ForYouAdapter : RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    private val judul = arrayOf("Judul 1", "Judul 2", "Judul 3", "Judul 4")
    private val penyayi = arrayOf("Taylor Swift", "Justin", "BTS", "Ed Sheeran")
    private val cover = arrayOf(R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var judul: TextView
        var penyayi: TextView
        var cover: ImageView

        init {
            judul = itemView.findViewById(R.id.judul)
            penyayi = itemView.findViewById(R.id.penyayi)
            cover = itemView.findViewById(R.id.albumcover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_album, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = judul[position]
        holder.penyayi.text = penyayi[position]
        holder.cover.setImageResource(cover[position])
    }

    override fun getItemCount(): Int {
        return judul.count()
    }
}