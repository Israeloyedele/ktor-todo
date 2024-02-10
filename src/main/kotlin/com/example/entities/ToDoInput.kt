package com.example.entities

import kotlinx.serialization.Serializable

@Serializable
data class ToDoInput (var title: String,
                      var body: String,
                      var done: Boolean
)
