package com.example.springSecurity

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val passwordEncoder: BCryptPasswordEncoder) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return when (username) {
            "user" -> User
                .withUsername(username)
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build()
            "admin" -> User
                .withUsername(username)
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN", "USER")
                .build()
            else -> throw UsernameNotFoundException("User not found")
        }
    }
}