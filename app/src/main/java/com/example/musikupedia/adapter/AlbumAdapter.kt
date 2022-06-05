package com.example.musikupedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.AlbumActivity
import com.example.musikupedia.R

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private val judulAlbum = arrayOf("Positions", "BE", "Happier Than Ever", "Coboy Junior", "Four")
    private val penyayi = arrayOf("Ariana Grande", "BTS", "Billie Eilish", "Coboy Junior", "One Direction")
    private val cover = arrayOf(R.drawable.cover_postitions, R.drawable.cover_be, R.drawable.cover_happierthanever, R.drawable.cover_coboyjunior, R.drawable.cover_four)

    private val music = arrayListOf(
        arrayListOf(R.raw.ariana_3435, R.raw.ariana_pov, R.raw.ariana_westside),
        arrayListOf(R.raw.be_bluegrey, R.raw.be_disease, R.raw.be_dynamite),
        arrayListOf(R.raw.bellie_yourpower, R.raw.billie_gettingolder, R.raw.billie_oxytocin),
        arrayListOf(R.raw.cjr_bubblegum, R.raw.cjr_demamunyuunyu, R.raw.cjr_eeeaaa),
        arrayListOf(R.raw.wandi_18, R.raw.wandi_nightchanges, R.raw.wandi_stealmygirl)
    )
    private val coverList = arrayListOf(
        arrayListOf(R.drawable.cover_postitions, R.drawable.cover_postitions, R.drawable.cover_postitions),
        arrayListOf(R.drawable.cover_be, R.drawable.cover_be, R.drawable.cover_be),
        arrayListOf(R.drawable.cover_happierthanever, R.drawable.cover_happierthanever, R.drawable.cover_happierthanever),
        arrayListOf(R.drawable.cover_coboyjunior, R.drawable.cover_coboyjunior, R.drawable.cover_coboyjunior),
        arrayListOf(R.drawable.cover_four, R.drawable.cover_four, R.drawable.cover_four),
    )
    val penyayiList = arrayListOf(
        arrayListOf("Ariana Grande", "Ariana Grande","Ariana Grande"),
        arrayListOf("BTS", "BTS", "BTS"),
        arrayListOf("Billie Ellish", "Billie Ellish","Billie Ellish"),
        arrayListOf("Coboy Junior", "Coboy Junior","Coboy Junior"),
        arrayListOf("One Direction", "One Direction","One Direction"),
    )
    val judulList = arrayListOf(
        arrayListOf("34+5", "Pov","West Side"),
        arrayListOf("Blue & Grey", "Dis-ease", "Dynamite"),
        arrayListOf("Your Power", "Getting Older","Oxytocin"),
        arrayListOf("Bubble GUm", "Demam Unyu Unyu","#Eeeaaa"),
        arrayListOf("18", "Night Changes","Steal My Girl"),
    )



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var judulAlbum: TextView
        var penyayi: TextView
        var cover: ImageView

        init {
            judulAlbum = itemView.findViewById(R.id.titleCoverAlbum)
            penyayi = itemView.findViewById(R.id.singerAlbum)
            cover = itemView.findViewById(R.id.albumcover2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_album_populer, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judulAlbum.text = judulAlbum[position]
        holder.penyayi.text = penyayi[position]
        holder.cover.setImageResource(cover[position])

        holder.cover.setOnClickListener{
            val context = holder.judulAlbum.context
            val intent = Intent( context, AlbumActivity::class.java)

            intent.putExtra("judul", judulAlbum[position])
            intent.putExtra("penyayi", penyayi[position])
            intent.putExtra("cover", cover[position])
            intent.putExtra("music", music[position])
            intent.putExtra("coverList", coverList[position])
            intent.putExtra("penyayiList", penyayiList[position])
            intent.putExtra("judulList", judulList[position])


            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return judulAlbum.count()
    }

}