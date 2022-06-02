package com.example.musikupedia.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.MusicActivity
import com.example.musikupedia.R


class ForYouAdapter : RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    private val judul = arrayOf("Judul 1", "Judul 2", "Judul 3", "Judul 4")
    private val penyayi = arrayOf("Taylor Swift", "Justin", "BTS", "Ed Sheeran")
    private val cover = arrayOf(R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.backgroundprofile)
    private val music = arrayOf(R.raw.money, R.raw.money, R.raw.money, R.raw.money)


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

        holder.cover.setOnClickListener{
            val context = holder.judul.context
            val intent = Intent( context, MusicActivity::class.java)
//            val bundle = Bundle()
//            bundle.putInt("cover", cover[position])

            intent.putExtra("judul", judul[position])
            intent.putExtra("cover", cover[position])
            intent.putExtra("music", music[position])

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return judul.count()
    }
}