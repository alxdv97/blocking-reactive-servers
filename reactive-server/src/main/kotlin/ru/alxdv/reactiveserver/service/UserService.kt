package ru.alxdv.reactiveserver.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.alxdv.reactiveserver.model.User
import ru.alxdv.reactiveserver.repository.UserRepository
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAll() : Flux<User> {
        return userRepository.findAll()
    }

    fun createUser(user: User): Mono<User> {
        val save = userRepository.save(user)
        println(LocalDateTime.now().toString() + "$save")
        return save
    }

    fun getAmount(): Mono<Long> {
        return userRepository.count()
    }
}