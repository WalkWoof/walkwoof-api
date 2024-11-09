package com.walkwoof.api.controller

import com.walkwoof.api.dto.UserRegisterDto
import com.walkwoof.api.service.JwtService
import com.walkwoof.api.service.RegistrationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RegisterController(
    private val registrationService: RegistrationService,
    private val jwtService: JwtService
) {

    @PostMapping("/register")
    fun register(@RequestBody @Valid userRegisterDto: UserRegisterDto): ResponseEntity<Any> {
        val user = registrationService.registerUser(userRegisterDto)

        val token = jwtService.generateToken(user)

        return ResponseEntity.ok(mapOf("token" to token))
    }
}