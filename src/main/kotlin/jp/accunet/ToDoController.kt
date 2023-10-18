package jp.accunet

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Controller("/todos")
class ToDoController {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): Map<String, String> {
        return mapOf("title" to "hoge", "description" to "fugafuga")
    }

    @Post("/")
    fun create(@Body request: CreateToDoRequestBody): Map<String, String> {
        return mapOf("title" to request.title, "description" to request.description)
    }
}

@Deserializable
data class CreateToDoRequestBody(var title: String = "", var description: String = "")
