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

    private val judul = arrayOf("Blu & Grey", "34 + 35", "18", "Demam Unyu")
    private val penyayi = arrayOf("BTS", "Ariana Grande", "One Direction", "Coboy Junior")
    private val cover = arrayOf(R.drawable.cover_be, R.drawable.cover_postitions, R.drawable.cover_four, R.drawable.cover_coboyjunior)
    private val music = arrayOf(R.raw.be_bluegrey, R.raw.ariana_3435, R.raw.wandi_18, R.raw.cjr_demamunyuunyu)


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
            intent.putExtra("penyayi", penyayi[position])
            intent.putExtra("cover", cover[position])
            intent.putExtra("music", music[position])

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return judul.count()
    }
}