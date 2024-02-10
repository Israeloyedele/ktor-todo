package com.example.repository

import com.example.entities.ToDo
import com.example.entities.ToDoInput

interface ToDoRepository {
    fun getAllTodos(): List<ToDo>

    fun getToDo(id: Int): ToDo?

    fun addTodo(input: ToDoInput) : ToDo

    fun updateToDo(id: Int, input: ToDoInput): Boolean

    fun deleteToDo(id: Int): Boolean
}