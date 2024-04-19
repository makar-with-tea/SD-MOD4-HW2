package com.example.springSecurity

import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/")
    fun home(): String {
        return "Welcome to the home page!"
    }

    @GetMapping("/hello-all")
    fun helloAll(): String {
        return "Hello All"
    }

    @GetMapping("/hello-user")
    @Secured("ROLE_USER")
    fun helloUser(): String {
        return "Hello User"
    }

    @GetMapping("/hello-admin")
    @Secured("ROLE_ADMIN")
    fun helloAdmin(): String {
        return "Hello Admin"
    }
}