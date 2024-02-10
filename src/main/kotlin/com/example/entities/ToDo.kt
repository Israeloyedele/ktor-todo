package com.example.entities

import kotlinx.serialization.Serializable

@Serializable
data class ToDo(
    var id: Int,
    var title: String,
    var body: String,
    var done: Boolean
)