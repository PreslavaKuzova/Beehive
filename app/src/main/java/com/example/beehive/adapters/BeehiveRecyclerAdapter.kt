package com.example.beehive.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beehive.R
import com.example.beehive.data.Beehive

class BeehiveRecyclerAdapter(private val data: List<Beehive>) :
    RecyclerView.Adapter<BeehiveViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeehiveViewHolder =
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_beehive,
            parent,
            false
        ).let {
            BeehiveViewHolder(it)
        }


    override fun onBindViewHolder(holder: BeehiveViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int =
        data.size
}

class BeehiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Beehive) {
        item.let {
            itemView.findViewById<TextView>(R.id.txtHeader).text = it.beehiveId
            itemView.findViewById<TextView>(R.id.txtOwner).text = it.ownerNames
            itemView.findViewById<TextView>(R.id.txtAddress).text =
                it.area + ", " + it.location + ", " + it.ownerAddress
            itemView.findViewById<TextView>(R.id.txtBeeFamilyCount).text =
                "Брой пчелни семейства: " + it.beeFamilyCount
        }
    }
}