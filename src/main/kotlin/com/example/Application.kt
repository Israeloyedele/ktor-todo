package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import javax.sound.sampled.Port

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
