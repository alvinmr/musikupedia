package com.example.musikupedia

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {
    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var mediaPlayer : MediaPlayer

    override fun onBackPressed() {
        mediaPlayer.stop()
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)


        judul_lagu.text = intent.getStringExtra("judul")
        artist.text = intent.getStringExtra("penyayi")
        val bundle = intent.extras
        var imagevalue = 0
        var musicvalue = 0

        if (bundle != null) {
            imagevalue = bundle.getInt("cover")
            musicvalue = bundle.getInt("music")
        }
        mediaPlayer = MediaPlayer.create(this, musicvalue)

        albumplaymusic.setImageResource(imagevalue)


        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration

        back_btn.setOnClickListener{
            mediaPlayer.pause()
            super.onBackPressed()
        }

        play_btn.setOnClickListener{
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                play_btn.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24)
            }else{
                mediaPlayer.pause()
                play_btn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
            }
        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed){
                    mediaPlayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)

        mediaPlayer.setOnCompletionListener {
            play_btn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
            seekBar.progress = 0
        }
    }
}