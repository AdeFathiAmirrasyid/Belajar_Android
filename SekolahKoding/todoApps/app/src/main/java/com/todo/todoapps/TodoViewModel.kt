package com.todo.todoapps

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.todo.todoapps.databade.Todo
import com.todo.todoapps.databade.TodoDAO
import com.todo.todoapps.databade.TodoDatabase
import com.todo.todoapps.databade.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application){

    // add Repository
    private  val repository : TodoRepository
    private  val todoDAO    : TodoDAO

    private var _todos : LiveData<List<Todo>>
    val todos : LiveData<List<Todo>>
    get() = _todos

    //coroutine
    private var vmJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.IO  + vmJob)



    init{
     todoDAO = TodoDatabase.getInstance(application).todoDAO()
        repository = TodoRepository(todoDAO)
        _todos = repository.allTodos
    }
    fun addTodo(text : String){
        uiScope.launch {
            repository.insert(Todo(0, text))
        }
    }
    fun removeTodo(todo: Todo){
        uiScope.launch {
            repository.delete(todo)
        }
    }
    fun updateTodo(pos : Int ,text: String){
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}

