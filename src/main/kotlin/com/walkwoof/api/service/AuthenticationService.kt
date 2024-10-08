package com.walkwoof.api.service

import com.walkwoof.api.dto.LoginRequest
import com.walkwoof.api.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val jwtService: JwtService
) {

    fun authenticate(loginRequest: LoginRequest): String {
        val user = userRepository.findByEmail(loginRequest.email)
            ?: throw Exception("Usuário inexistente")

        if (!bCryptPasswordEncoder.matches(loginRequest.password, user.password)) {
            throw Exception("Senha incorreta")
        }

        return jwtService.generateToken(user)
    }
}