package ru.alxdv.blockingserver.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.alxdv.blockingserver.model.User

interface UserRepository : JpaRepository<User, Long>