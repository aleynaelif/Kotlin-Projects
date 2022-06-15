package com.ley.favalbums

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ley.favalbums.databinding.RecyclerRowBinding

class AlbumAdapter (val albumList : ArrayList<Album>): RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {
    class AlbumHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {

        val binding =  RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlbumHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {

        holder.binding.recyclerViewTextView.text = albumList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",albumList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}