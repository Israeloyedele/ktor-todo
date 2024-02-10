package com.example.database

import com.example.entities.DBTodoEntity
import com.example.entities.DBTodoTable
import com.example.entities.ToDo
import com.example.entities.ToDoInput
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {
    private val hostname = ""
    private val databaseName = ""
    private val username = ""
    private val password = ""
    private val database: Database

    init {
        val jdbcURL = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password"
        database = Database.connect(jdbcURL)
    }

    fun getAllTodos(): List<DBTodoEntity>{
        return database.sequenceOf(DBTodoTable).toList()
    }
    fun getToDo(id: Int): DBTodoEntity?{
        return database.sequenceOf(DBTodoTable)
            .firstOrNull { it.id eq id }
    }
    fun addToDo(input: ToDoInput): ToDo{
        val generatedId = database.insertAndGenerateKey(DBTodoTable){
            set(DBTodoTable.title, input.title)
            set(DBTodoTable.body, input.body)
            set(DBTodoTable.done, input.done)
        } as Int
        return ToDo(generatedId, input.title, input.body, input.done)
    }
    fun updateToDo(id: Int, input: ToDoInput): Boolean{
        val updatedRows = database.update(DBTodoTable){
            set(DBTodoTable.title, input.title)
            set(DBTodoTable.body, input.body)
            set(DBTodoTable.done, input.done)
            where { it.id eq id }
        }
        return updatedRows > 0
    }
    fun deleteToDo(id: Int): Boolean{
        val isDeleted = database.delete(DBTodoTable){
            it.id eq id
        } > 0
        return isDeleted
    }
}