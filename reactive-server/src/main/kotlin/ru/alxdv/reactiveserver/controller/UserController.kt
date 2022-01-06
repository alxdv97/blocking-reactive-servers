package ru.alxdv.reactiveserver.controller

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.alxdv.reactiveserver.model.User
import ru.alxdv.reactiveserver.service.UserService

@RestController
@RequestMapping("/reactive/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll(): Flux<User> {
        return userService.getAll()
    }

    @GetMapping("/amount")
    fun getAmount(): Mono<Long> {
        return userService.getAmount()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): Mono<User> {
        return userService.createUser(user)
    }
}