package com.walkwoof.api

import com.walkwoof.api.dto.LoginRequest
import com.walkwoof.api.entity.User
import com.walkwoof.api.repository.UserRepository
import com.walkwoof.api.service.AuthenticationService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class AuthenticationServiceTest {

    private val userRepository = mock(UserRepository::class.java)
    private val passwordEncoder = BCryptPasswordEncoder()

    private val authenticationService = AuthenticationService(userRepository, passwordEncoder)

    @Test
    fun `O login deve suceder quando as credenciais forem validas`() {
        val user = User(
            email = "test@exemplo.com",
            password = passwordEncoder.encode("teste de senha"),
            role = "User"
        )
        `when`(userRepository.findByEmail("test@exemplo.com")).thenReturn(user)

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
            password = passwordEncoder.encode("teste de senha"),
            role = "User"
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
}

