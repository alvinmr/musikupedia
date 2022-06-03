package com.example.musikupedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.R

class ArtisAdapter : RecyclerView.Adapter<ArtisAdapter.ViewHolder>() {

    private val judul = arrayOf("Ariana Grande", "BTS", "One Direction", "Billie Ellish", "Coboy Junior")
    private val cover = arrayOf(R.drawable.profile_ariana, R.drawable.profile_bts, R.drawable.profile_1d, R.drawable.profile_billie, R.drawable.profile_cjr)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var judul: TextView
        var cover: ImageView

        init {
            judul = itemView.findViewById(R.id.titleCoverAlbum)
            cover = itemView.findViewById(R.id.albumcover3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtisAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_artis_populer, parent, false)
        return ArtisAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ArtisAdapter.ViewHolder, position: Int) {
        holder.judul.text = judul[position]
        holder.cover.setImageResource(cover[position])
    }

    override fun getItemCount(): Int {
        return judul.count()
    }

}