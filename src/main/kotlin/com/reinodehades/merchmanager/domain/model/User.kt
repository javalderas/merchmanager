package com.reinodehades.merchmanager.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val email: String,

    val password: String // Hasheada con BCrypt
)