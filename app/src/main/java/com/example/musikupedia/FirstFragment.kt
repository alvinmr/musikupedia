package com.example.musikupedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musikupedia.adapter.AlbumAdapter
import com.example.musikupedia.adapter.ArtisAdapter
import com.example.musikupedia.adapter.ForYouAdapter
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<ForYouAdapter.ViewHolder>? = null
    private val adapterAlbum: RecyclerView.Adapter<AlbumAdapter.ViewHolder>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSearch.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = ForYouAdapter()
            addItemDecoration(DividerItemDecoration(activity, GridLayoutManager.HORIZONTAL))
        }

        recyclerView2.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = AlbumAdapter()
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        }

        recyclerView3.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = ArtisAdapter()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

}