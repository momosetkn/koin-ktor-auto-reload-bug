package com.example.plugins

import com.example.HELLO_WORLD_STRING
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.qualifier.named
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val responseMessage by inject<String>(named(HELLO_WORLD_STRING))

    routing {
        get("/") {
            call.respondText(responseMessage)
        }
    }
}
