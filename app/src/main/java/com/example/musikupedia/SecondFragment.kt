package com.example.musikupedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.adapter.AlbumAdapter
import com.example.musikupedia.adapter.ForYouAdapter
import com.example.musikupedia.adapter.SearchAdapter
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_third.*
import java.util.*

class SecondFragment : Fragment() {
    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<ForYouAdapter.ViewHolder>? = null
    private val adapterAlbum: RecyclerView.Adapter<AlbumAdapter.ViewHolder>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView1.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = SearchAdapter()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}