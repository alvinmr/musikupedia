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
            var coverList = intent.getIntegerArrayListExtra("coverList")
            var penyayiList = intent.getStringArrayListExtra("penyayiList")
            var judulList = intent.getStringArrayListExtra("judulList")
            albumtitle.text = intent.getStringExtra("judul")
            albumsinger.text = intent.getStringExtra("penyayi")
            val bundle = intent.extras
            var imagevalue = 0

            if (bundle != null) {
                imagevalue = bundle.getInt("cover")
            }
            album_isi.setImageResource(intent.getIntExtra("cover", 0))

            adapter = IsiAlbum(musicvalue, coverList, penyayiList, judulList)
        }


    }
}