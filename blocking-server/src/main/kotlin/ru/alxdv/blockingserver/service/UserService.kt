package ru.alxdv.blockingserver.service

import org.springframework.stereotype.Service
import ru.alxdv.blockingserver.model.User
import ru.alxdv.blockingserver.repository.UserRepository
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAll() : List<User> {
        return userRepository.findAll()
    }

    fun getById(id: Long): User {
        return userRepository.findById(id).orElseThrow()
    }

    fun createUser(user: User): User{
        val save = userRepository.save(user)
        println(LocalDateTime.now().toString() + "$save")
        return save
    }

    fun getAmount(): Long {
        return userRepository.count()
    }


}