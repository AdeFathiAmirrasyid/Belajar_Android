package com.insanie.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewOnePieceAdapter(val listOnepiece: ArrayList<OnePiece>) :
    RecyclerView.Adapter<CardViewOnePieceAdapter.CardviewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardviewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_cardview_onepiece, viewGroup, false)
        return CardviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardviewViewHolder, position: Int) {
        val onePiece = listOnepiece[position]
        Glide.with(holder.itemView.context)
            .load(onePiece.data_image)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgImage)

        holder.tvName.text = onePiece.data_name
        holder.tvDetail.text = onePiece.data_detail

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + listOnepiece[holder.adapterPosition].data_name,
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.btnShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Shere " + listOnepiece[holder.adapterPosition].data_name,
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu Memilih " + listOnepiece[holder.adapterPosition].data_name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listOnepiece.size
    }

    class CardviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImage: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        val btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }
}