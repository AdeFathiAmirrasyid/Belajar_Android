package com.insanie.wisata_indonesia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_wisata.view.*
import java.util.zip.Inflater

class WisataAdapter(val arrayList: ArrayList<Wisata>, val sharedPref: SharedPref) :
    RecyclerView.Adapter<WisataAdapter.ViewHolder>() {

    var onItemClickListener: ((Wisata) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(wisata: Wisata) {
            itemView.itemName.text = wisata.dataName
            itemView.itemDesc.text = wisata.dataDesc
            itemView.itemImage.setImageResource(wisata.dataImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wisata = arrayList[position]
        holder.setData(wisata)
        holder.itemView.setOnClickListener() {
            onItemClickListener?.invoke(wisata)
        }
        holder.itemView.itemDesc.visibility = if (sharedPref.descriptions)
            View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}