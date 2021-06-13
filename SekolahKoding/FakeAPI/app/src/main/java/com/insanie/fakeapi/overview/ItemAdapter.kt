package com.insanie.fakeapi.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.insanie.fakeapi.database.User
import com.insanie.fakeapi.databinding.ListItemsBinding
import com.insanie.fakeapi.network.SampleData

class ItemAdapter : ListAdapter<User, ItemAdapter.SampleViewHolder>(DiffCallback){

        override fun onCreateViewHolder(parent: ViewGroup,viewType : Int):SampleViewHolder{
            return SampleViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context)))
        }
        override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)
        }

    class SampleViewHolder(private var binding : ListItemsBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(userData : User){
            binding.item = userData
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }
}