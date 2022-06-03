package com.example.musikupedia.adapter

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.MusicActivity
import com.example.musikupedia.R
import java.util.ArrayList

class IsiAlbum(val music : ArrayList<Int>?) : RecyclerView.Adapter<IsiAlbum.ViewHolder>() {

    private val judul = arrayOf("Playlist name 1", "Playlist name 2", "Playlist name 3")
    private val descriptionLibrary = arrayOf("Lagu tentang ...", "Lagu ini tentang", "", "Lagunya enak")
    private val cover = arrayOf(R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin, R.drawable.album_justin)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var judul: TextView
        var descriptionLibrary: TextView
        var cover: ImageView

        init {
            judul = itemView.findViewById(R.id.judulLibrary)
            descriptionLibrary = itemView.findViewById(R.id.descriptionLibrary)
            cover = itemView.findViewById(R.id.albumcoverLibrary)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_isi_album, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = judul[position]
        holder.descriptionLibrary.text = descriptionLibrary[position]
        holder.cover.setImageResource(cover[position])

        holder.cover.setOnClickListener{
            val context = holder.judul.context
            val intent = Intent( context, MusicActivity::class.java)

            intent.putExtra("judul", judul[position])
            intent.putExtra("penyayi", descriptionLibrary[position])
            intent.putExtra("cover", cover[position])
            intent.putExtra("music", music!![position])

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return judul.count()
    }
}