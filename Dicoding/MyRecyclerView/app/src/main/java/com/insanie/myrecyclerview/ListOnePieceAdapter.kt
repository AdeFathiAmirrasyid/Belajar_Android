package com.insanie.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListOnePieceAdapter(private val listOnePiece: ArrayList<OnePiece>) :
    RecyclerView.Adapter<ListOnePieceAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_onepiece, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val onePiece = listOnePiece[position]

        Glide.with(holder.itemView.context)
            .load(onePiece.data_image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgImage)

        holder.tvNames.text = onePiece.data_name
        holder.tvDetails.text = onePiece.data_detail
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listOnePiece[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listOnePiece.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNames: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetails: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgImage: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: OnePiece)
    }
}





