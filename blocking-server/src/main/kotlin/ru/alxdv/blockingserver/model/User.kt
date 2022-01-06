package ru.alxdv.blockingserver.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Long,

    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

)
