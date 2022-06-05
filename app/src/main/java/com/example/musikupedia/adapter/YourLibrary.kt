package com.example.musikupedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.MusicActivity
import com.example.musikupedia.R

class YourLibrary : RecyclerView.Adapter<YourLibrary.ViewHolder>() {

    private val judul = arrayOf("34+5", "Pov", "West Side", "Blu & Grey", "Dis-ease", "Dynamite", "Your Power", "Getting Older", "Oxytocin", "Bubble Gum", "Demam Unyu", "#Eeeaa", "18", "Night Changes", "Steal My Girl")
    private val descriptionLibrary = arrayOf("Ariana Grande", "Ariana Grande", "Ariana Grande", "BTS", "BTS", "BTS", "Billie Ellish", "Billie Ellish", "Billie Ellish", "Coboy Junior", "Coboy Junior", "Coboy Junior", "One Direction", "One Direction", "One Direction")
    private val cover = arrayOf(R.drawable.cover_postitions, R.drawable.cover_postitions, R.drawable.cover_postitions, R.drawable.cover_be, R.drawable.cover_be, R.drawable.cover_be, R.drawable.cover_happierthanever, R.drawable.cover_happierthanever, R.drawable.cover_happierthanever, R.drawable.cover_coboyjunior, R.drawable.cover_coboyjunior, R.drawable.cover_coboyjunior, R.drawable.cover_four, R.drawable.cover_four, R.drawable.cover_four)
    private val music = arrayOf(R.raw.ariana_3435, R.raw.ariana_pov, R.raw.ariana_westside, R.raw.be_bluegrey, R.raw.be_disease, R.raw.be_dynamite, R.raw.bellie_yourpower, R.raw.billie_gettingolder, R.raw.billie_oxytocin, R.raw.cjr_bubblegum, R.raw.cjr_demamunyuunyu, R.raw.cjr_eeeaaa, R.raw.wandi_18, R.raw.wandi_nightchanges, R.raw.wandi_stealmygirl)


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
            .inflate(R.layout.listitem_library, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = judul[position]
        holder.descriptionLibrary.text = descriptionLibrary[position]
        holder.cover.setImageResource(cover[position])

        holder.itemView.setOnClickListener{
            val context = holder.judul.context
            val intent = Intent( context, MusicActivity::class.java)

            intent.putExtra("judul", judul[position])
            intent.putExtra("penyayi", descriptionLibrary[position])
            intent.putExtra("cover", cover[position])
            intent.putExtra("music", music[position])

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return judul.count()
    }

}