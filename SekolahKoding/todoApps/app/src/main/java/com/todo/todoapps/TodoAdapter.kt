package com.todo.todoapps


import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.todo.todoapps.databade.Todo
import com.todo.todoapps.databinding.ListItemBinding

class TodoAdapter(private val viewModel: TodoViewModel) :
        ListAdapter<Todo, TodoAdapter.MyViewHolder>(TodoDiffcallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  = ListItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.todoText.text =getItem(holder.adapterPosition).task

        holder.delBtn.setOnClickListener(){
            viewModel.removeTodo(getItem(holder.adapterPosition))
        }

        holder.editBtn.setOnClickListener{
            val context  = holder.itemView.context
            val inflater = LayoutInflater.from(context)
            val view     = inflater.inflate(R.layout.edit_item,null)

            var prevText = getItem(holder.adapterPosition).task
            val editText = view.findViewById<TextView>(R.id.editTodo)
            editText.text = prevText

            var alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Item").setView(view)
                .setPositiveButton("Update",DialogInterface.OnClickListener{ dialog, id ->

                    val editedText = editText.text.toString()
                    viewModel.updateTodo(holder.adapterPosition,editedText)
                    holder.todoText.text = editedText
                })
                .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog,id ->
                })
            alertDialog.create().show()
        }
    }
    class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val todoText = binding.todoItem
        val delBtn   = binding.btnDelete
        val editBtn  = binding.btnEdit
    }
}
class TodoDiffcallback : DiffUtil.ItemCallback<Todo>(){
    override fun areItemsTheSame(p0: Todo, p1: Todo): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Todo, p1: Todo): Boolean {
        return p0.equals(p1)
    }
}