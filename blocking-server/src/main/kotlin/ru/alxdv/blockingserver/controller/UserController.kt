package ru.alxdv.blockingserver.controller

import org.springframework.web.bind.annotation.*
import ru.alxdv.blockingserver.model.User
import ru.alxdv.blockingserver.service.UserService

@RestController
@RequestMapping("/blocking/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll(): List<User> {
        return userService.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): User{
        return userService.getById(id)
    }

    @GetMapping("/amount")
    fun getAmount(): Long{
        return userService.getAmount()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }
}