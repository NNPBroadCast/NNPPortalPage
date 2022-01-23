package net.n_nichidai.plugins

import com.mitchellbosecke.pebble.loader.ClasspathLoader
import io.ktor.pebble.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureTemplating() {
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix = "templates"
        })
    }

    routing {
        get("/") {
            val template = "index"
            call.respond(PebbleContent("root.html", mapOf("template" to template)))
        }
    }
}

data class User(val id: Int, val name: String)
