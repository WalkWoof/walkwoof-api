package com.walkwoof.api

import com.walkwoof.api.dto.LoginRequest
import com.walkwoof.api.entity.User
import com.walkwoof.api.repository.UserRepository
import com.walkwoof.api.service.AuthenticationService
import com.walkwoof.api.service.JwtService
import com.walkwoof.api.util.UserRole
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class AuthenticationServiceTest {

    private val userRepository = mock(UserRepository::class.java)
    private val passwordEncoder = BCryptPasswordEncoder()
    private val jwtService = mock(JwtService::class.java)

    private val authenticationService = AuthenticationService(userRepository, passwordEncoder, jwtService)

    @Test
    fun `O login deve suceder quando as credenciais forem validas`() {
        val user = User(
            email = "test@exemplo.com",
            userPassword = passwordEncoder.encode("teste de senha"),
            role = UserRole.OWNER
        )
        `when`(userRepository.findByEmail("test@exemplo.com")).thenReturn(user)
        `when`(jwtService.generateToken(user)).thenReturn("fake-jwt-token")

        val token = authenticationService.authenticate(
            loginRequest = LoginRequest(
                "test@exemplo.com",
                "teste de senha"
            )
        )

        assertNotNull(token)

    }

    @Test
    fun `O login deve falhar quando a senha for incorreta`() {
        val user = User(
            email = "test@exemplo.com",
            userPassword = passwordEncoder.encode("teste de senha"),
            role = UserRole.OWNER
        )
        `when`(userRepository.findByEmail("test@exemplo.com")).thenReturn(user)

        val exception = assertThrows(Exception::class.java) {
            authenticationService.authenticate(
                loginRequest = LoginRequest(
                    "test@exemplo.com",
                    "senha errada"
                )
            )
        }

        assertEquals("Senha incorreta", exception.message)
    }

    @Test
    fun `O login deve falhar quando o usuario nao existe`() {
        `when`(userRepository.findByEmail("emailinexistente@exemplo.com")).thenReturn(null)

        val exception = assertThrows(Exception::class.java) {
            authenticationService.authenticate(
                loginRequest = LoginRequest(
                    "emailinexistente@exemplo.com",
                    "senha"
                )
            )
        }

        assertEquals("Usuário inexistente", exception.message)
    }

    @Test
    fun `O login deve suceder e retornar uma string com o token`() {
        val jwtService = JwtService()
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        val user = User(
            email = "test@exemplo.com",
            userPassword = bCryptPasswordEncoder.encode("teste de senha"),
            role = UserRole.OWNER
        )

        val authenticationService = AuthenticationService(userRepository, bCryptPasswordEncoder, jwtService)

        `when`(userRepository.findByEmail("test@exemplo.com")).thenReturn(user)

        println("teste 1: " + jwtService.generateToken(user))
        println("teste 2: " + authenticationService.authenticate(loginRequest = LoginRequest("test@exemplo.com", "teste de senha")))

    }
}

