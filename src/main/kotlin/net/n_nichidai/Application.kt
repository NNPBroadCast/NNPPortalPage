package net.n_nichidai

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.n_nichidai.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureTemplating()
        configureSerialization()
    }.start(wait = true)
}
