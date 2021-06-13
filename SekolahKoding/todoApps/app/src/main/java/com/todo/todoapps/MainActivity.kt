package com.todo.todoapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todo.todoapps.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var recycleView : RecyclerView
    lateinit var viewAdapter : TodoAdapter
    lateinit var viewManager : RecyclerView.LayoutManager

    private lateinit var viewModel: TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)


        viewManager = LinearLayoutManager(this)
        viewAdapter = TodoAdapter(viewModel)

        recycleView = binding.myRecycleView
        recycleView.apply {
            layoutManager = viewManager
            adapter       = viewAdapter
        }

        binding.btnNew.setOnClickListener{
            viewModel.addTodo(binding.newTodo.text.toString())
            binding.newTodo.setText(null)
        }
        viewModel.todos.observe(this, Observer { list ->
            viewAdapter.submitList(list.toMutableList())
        })
    }
}