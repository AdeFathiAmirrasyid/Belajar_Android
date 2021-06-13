package com.insanie.apprecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListAdapterOnePiece(val listOnePiece: ArrayList<ModelOnePiece>) :
    RecyclerView.Adapter<ListAdapterOnePiece.ListViewHolder>() {

    var onItemClickListener: ((ModelOnePiece) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_onepiece, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val modeListOnePiece = listOnePiece[position]

        Glide.with(holder.itemView.context)
            .load(modeListOnePiece.data_image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgImage)

        holder.tvNames.text = modeListOnePiece.data_name
        holder.tvDesc.text = modeListOnePiece.data_desc
        holder.tvTime.text = modeListOnePiece.data_time
        holder.itemView.setOnClickListener(){
            onItemClickListener?.invoke(modeListOnePiece)
        }
    }

    override fun getItemCount(): Int {
        return listOnePiece.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNames: TextView = itemView.findViewById(R.id.item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.itemDesc)
        val tvTime: TextView = itemView.findViewById(R.id.itemTime)
        val imgImage: ImageView = itemView.findViewById(R.id.item_image)
    }
}


