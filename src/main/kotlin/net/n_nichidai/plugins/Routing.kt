package net.n_nichidai.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }
//        get("/articles/{id}") {
//            var id = call.parameters["id"].toString()
//        }
        static("/static") {
            resources("static")
        }
    }
}
