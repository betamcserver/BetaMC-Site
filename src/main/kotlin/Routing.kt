package org.betamc

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.pebble.*
import io.pebbletemplates.pebble.loader.ClasspathLoader
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!")
        }
        get("/pebble-index") {
            val sampleUser = PebbleUser(1, "John")
            call.respond(PebbleContent("pebble-index.html", mapOf("user" to sampleUser)))
        }
        staticResources("/static", "static")
    }
}