package com.example.musikupedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.R

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private val judul = arrayOf("Judul 1", "Judul 2", "Judul 3", "Judul 4")
    private val penyayi = arrayOf("Taylor Swift", "Justin", "BTS", "Ed Sheeran")
    private val cover = arrayOf(R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var judul: TextView
        var penyayi: TextView
        var cover: ImageView

        init {
            judul = itemView.findViewById(R.id.titleCover)
            penyayi = itemView.findViewById(R.id.singer)
            cover = itemView.findViewById(R.id.albumcover2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_album_populer, parent, false)
        return AlbumAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolder, position: Int) {
        holder.judul.text = judul[position]
        holder.penyayi.text = penyayi[position]
        holder.cover.setImageResource(cover[position])
    }

    override fun getItemCount(): Int {
        return judul.count()
    }

}