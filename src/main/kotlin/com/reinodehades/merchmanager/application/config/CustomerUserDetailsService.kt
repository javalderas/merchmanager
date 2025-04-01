package com.reinodehades.merchmanager.application.config


import com.reinodehades.merchmanager.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    private val logger = Logger.getLogger(CustomUserDetailsService::class.java.name)

    override fun loadUserByUsername(email: String): UserDetails {
        logger.info("Loading user by email: $email")
        val user = userRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("User not found: $email")

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.email)
            .password(user.password)
            .roles("USER") // Por ahora, sin roles complejos
            .build()
    }
}