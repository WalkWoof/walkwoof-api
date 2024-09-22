package com.walkwoof.api.service

import com.walkwoof.api.dto.LoginRequest
import com.walkwoof.api.entity.User
import com.walkwoof.api.repository.UserRepository
import com.walkwoof.api.util.JwtKey
import io.jsonwebtoken.Jwts
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {

    val jwtKey = JwtKey("469DBB9A2F36E8A22F8E172C0C381C781CF40C40E3AC3CBEB58A09137220F791")
    private val expirationTime = 1000 * 60 * 10 // 10 minutos

    fun authenticate(loginRequest: LoginRequest): String {
        val user = userRepository.findByEmail(loginRequest.email)
            ?: throw Exception("Usuário inexistente")

        if (!bCryptPasswordEncoder.matches(loginRequest.password, user.password)) {
            throw Exception("Senha incorreta")
        }

        return generateToken(user)
    }

    private fun generateToken(user: User): String {
        val claims = mapOf("role" to user.role)
        val key = jwtKey.receiveKey()

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(user.email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(key)
            .compact()
    }
}