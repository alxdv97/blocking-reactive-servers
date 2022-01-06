package ru.alxdv.reactiveserver.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import ru.alxdv.reactiveserver.model.User

@Repository
interface UserRepository: ReactiveCrudRepository<User, Long> {
}