package com.ley.favsitcomcharacters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ley.favsitcomcharacters.databinding.RecyclerRowBinding

class SitcomAdapter(val sitcomList: ArrayList<Sitcom>) : RecyclerView.Adapter<SitcomAdapter.SitcomHolder> (){
    class SitcomHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitcomHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SitcomHolder(binding)
    }

    override fun onBindViewHolder(holder: SitcomHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = sitcomList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("sitcom",sitcomList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return sitcomList.size
    }
}