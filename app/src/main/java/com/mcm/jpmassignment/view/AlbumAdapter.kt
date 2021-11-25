package com.mcm.jpmassignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mcm.jpmassignment.R
import com.mcm.jpmassignment.databinding.LayoutAlbumBinding
import com.mcm.jpmassignment.model.Albums

class AlbumAdapter(val albums: List<Albums>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumAdapter.ViewHolder {
        val binding: LayoutAlbumBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_album,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolder, position: Int) {
        val albums = albums.get(position)
        val albumTitle = albums.title
        holder.binding.tvtitle.text = albumTitle
    }

    inner class ViewHolder(val binding: LayoutAlbumBinding) :
        RecyclerView.ViewHolder(binding.root)
}
