package net.n_nichidai

import io.ktor.routing.*
import io.ktor.http.*
import com.mitchellbosecke.pebble.loader.ClasspathLoader
import io.ktor.pebble.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.jackson.*
import com.fasterxml.jackson.databind.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import net.n_nichidai.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}