package com.example.repository

import com.example.database.DatabaseManager
import com.example.entities.*

class ToDoRepositoryImpl: ToDoRepository {

    private val database = DatabaseManager()

    override fun getAllTodos(): List<ToDo> {
        return database.getAllTodos()
            .map { ToDo(it.id, it.title, it.body, it.done) }
    }

    override fun getToDo(id: Int): ToDo? {
        return database.getToDo(id)?.let { ToDo(it.id, it.title, it.body, it.done) }
    }

    override fun addTodo(input: ToDoInput): ToDo {
        return database.addToDo(input)
    }

    override fun updateToDo(id: Int, input: ToDoInput): Boolean {
        return database.updateToDo(id, input )
    }

    override fun deleteToDo(id: Int): Boolean {
        return database.deleteToDo(id)
    }
}