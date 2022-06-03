package com.example.musikupedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.adapter.AlbumAdapter
import com.example.musikupedia.adapter.IsiAlbum
import com.example.musikupedia.adapter.YourLibrary
import kotlinx.android.synthetic.main.activity_album.*
import kotlinx.android.synthetic.main.activity_music.*
import kotlinx.android.synthetic.main.listitem_isi_album.*

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)


        recyclerViewAlbum.apply{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            var musicvalue = intent.getIntegerArrayListExtra("music")
//            judulLibrary.text = intent.getStringExtra("judulAlbum")
//            descriptionLibrary.text = intent.getStringExtra("penyayi")

            adapter = IsiAlbum(musicvalue)
        }


    }
}