package com.insanie.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridOnePieceAdapter(val listOnePiece: ArrayList<OnePiece>) :
    RecyclerView.Adapter<GridOnePieceAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_onepiece, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listOnePiece[position].data_image)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgImage)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listOnePiece[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listOnePiece.size
    }

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImage: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: OnePiece)
    }
}