package com.example.plugins

import com.example.entities.Response
import com.example.entities.ToDoInput
import com.example.repository.ToDoRepository
import com.example.repository.ToDoRepositoryImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        val repository: ToDoRepository = ToDoRepositoryImpl()

        get("/") {
            call.respondRedirect("todos")
        }
        get("/todos"){
            call.respond(HttpStatusCode.OK, Response(true, repository.getAllTodos()))
        }
        get("/todos/{id}"){
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest,
                    Response(false, "Id should be an integer")
                )
                return@get
            }
            val todo = repository.getToDo(id)
            if (todo == null) {
                call.respond(HttpStatusCode.NotFound, Response(false, "No todo with Id: $id was found"))
                return@get
            }
            call.respond(HttpStatusCode.OK, Response(true, todo))
        }
        post("/todos") {
            val todoInput = call.receive<ToDoInput>()
            val todo = repository.addTodo(todoInput)
            call.respond(HttpStatusCode.OK, Response(true, todo))

        }
        put("/todos/{id}"){
            val id = call.parameters["id"]?.toIntOrNull()
            val todoInput = call.receive<ToDoInput>()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest,
                    Response(false, "Id should be an integer")
                )
                return@put
            }
            if (repository.updateToDo(id, todoInput)){
                call.respond(HttpStatusCode.OK, Response(true, "Successfully Updated a todo"))
                return@put
            }
            call.respond(HttpStatusCode.NotFound, Response(false, "Todo with Id: $id was not found"))
        }
        delete("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest,
                    Response(false, "Id should be an integer")
                )
                return@delete
            }
            if (repository.deleteToDo(id)){
                call.respond(HttpStatusCode.OK, Response(true, "Successfully Deleted a todo"))
                return@delete
            }
            call.respond(HttpStatusCode.NotFound, Response(false, "Todo with Id: $id was not found"))
        }
    }
}
