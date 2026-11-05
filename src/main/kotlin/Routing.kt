package org.betamc

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.pebble.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        staticResources("/static", "static")

        get("/") {
            call.respond(
                PebbleContent(
                    "index.peb",
                    mapOf("title" to "Hello, Ktor!")
                )
            )
        }

        sitemap()
    }
}
