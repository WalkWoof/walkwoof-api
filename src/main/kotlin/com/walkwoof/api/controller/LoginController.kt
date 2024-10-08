package com.walkwoof.api.controller

import com.walkwoof.api.dto.LoginRequest
import com.walkwoof.api.service.AuthenticationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class LoginController(
    private val authenticationService: AuthenticationService
) {

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginRequest: LoginRequest): ResponseEntity<Any> {
        val token = authenticationService.authenticate(loginRequest)
        return ResponseEntity.ok(mapOf("token" to token))
    }
}