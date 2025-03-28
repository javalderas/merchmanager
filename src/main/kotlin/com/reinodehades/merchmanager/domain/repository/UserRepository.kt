package com.reinodehades.merchmanager.domain.repository

import com.reinodehades.merchmanager.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}