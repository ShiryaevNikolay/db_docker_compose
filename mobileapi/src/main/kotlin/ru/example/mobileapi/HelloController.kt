package ru.example.mobileapi

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Контроллер - то, что обрабатывает запрос с клиента и возвращает ответ с требуемой
 * информацией.
 */
@RestController
@RequestMapping("/mobile")
class HelloController {
    @RequestMapping(
        value = ["/helloWorld"],
        method = [(RequestMethod.GET)]
    )
    fun getHelloWorldMessage(): ResponseEntity<String> = ResponseEntity.ok("Hello, World!")

    @RequestMapping(
        value = ["/helloWorld/{name}"],
        method = [(RequestMethod.GET)]
    )
    fun getHelloWorldWithName(
        @PathVariable("name") name: String
    ): ResponseEntity<Any> =
        if (name != "Bob") {
            ResponseEntity.ok(
                HelloResponse(
                    message = "Hello, $name",
                    name = name
                )
            )
        } else {
            ResponseEntity.badRequest().body("I am Bob!")
        }
}

/**
 * Модель ответа от сервера
 */
data class HelloResponse(
    val message: String,
    val name: String
)