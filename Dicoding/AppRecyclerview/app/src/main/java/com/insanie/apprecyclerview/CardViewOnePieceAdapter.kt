package com.insanie.apprecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class CardViewOnePieceAdapter(val listOnePiece: ArrayList<ModelOnePiece>) :
    RecyclerView.Adapter<CardViewOnePieceAdapter.CardviewViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardviewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_cardview_onepiece, viewGroup, false)
        return CardviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardviewViewHolder, position: Int) {
        val onePiece = listOnePiece[position]
        Glide.with(holder.itemView.context)
            .load(onePiece.data_image)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgImage)

        holder.btnFavorit.setOnClickListener {
            onItemClickCallback.onItemClicked(listOnePiece[holder.adapterPosition])
        }


        // source code ini untuk button  shere
        holder.btnShere.setOnClickListener {
            onItemClickCallback.onItemClickedShere(
                Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,data)
                type = "text/plain"
            })
        }

    }
    override fun getItemCount(): Int {
        return listOnePiece.size
    }

    class CardviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImage: ImageView = itemView.findViewById(R.id.item_image)
        val btnFavorit: Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShere: Button = itemView.findViewById(R.id.btn_set_share)
    }


    // source code ini untuk callback manual dari adapter ke activity apa saja
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    
    // source code ini untuk callback manual dari adapter ke activity apa saja
    interface OnItemClickCallback {
        fun onItemClicked(data: ModelOnePiece)
        fun onItemClickedShere(sendIntent : Intent)
    }
}


