package com.example.entities

import kotlinx.serialization.Serializable

@Serializable
data class Response<out T>(val success: Boolean, val data:T)
