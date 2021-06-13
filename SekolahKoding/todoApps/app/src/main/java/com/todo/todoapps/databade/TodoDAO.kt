package com.todo.todoapps.databade

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO {
    @Query("SELECT * FROM Todo")
    fun loadTodos(): LiveData<List<Todo>>

    @Insert
    fun insertTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

}