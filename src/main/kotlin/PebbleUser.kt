package org.betamc

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*

data class PebbleUser(val id: Int, val name: String)
