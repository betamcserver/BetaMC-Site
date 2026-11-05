package org.betamc

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.pebbletemplates.pebble.loader.ClasspathLoader
import io.pebbletemplates.pebble.loader.FileLoader

fun Application.configurePebble() {
    val isDev = developmentMode

    install(Pebble) {
        if (isDev) {
            loader(FileLoader("/app/src/main/resources/templates"))
            cacheActive(false)
        } else {
            loader(ClasspathLoader().apply {
                prefix = "templates"
            })
        }
    }
}
