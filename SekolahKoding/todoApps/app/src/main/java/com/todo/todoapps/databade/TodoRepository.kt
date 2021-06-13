package com.todo.todoapps.databade

class TodoRepository(private val TodoDAO : TodoDAO){

    val allTodos = TodoDAO.loadTodos()


    suspend fun insert(todo: Todo){
        TodoDAO.insertTodo(todo)
    }

    suspend fun delete(todo: Todo){
        TodoDAO.deleteTodo(todo)
    }
}