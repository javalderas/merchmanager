package com.reinodehades.merchmanager.application


import com.reinodehades.merchmanager.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.userdetails.User as SpringUser
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("User not found: $email")

        return SpringUser.withUsername(user.email)
            .password(user.password)
            .roles("USER") // Por ahora, sin roles complejos
            .build()
    }
}