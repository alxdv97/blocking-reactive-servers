package ru.alxdv.reactiveserver.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    @Id
    val id: Long,
    var username: String,
    var password: String,
)
