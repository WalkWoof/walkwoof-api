package com.walkwoof.api.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginRequest(
    @field:Email(message = "O e-mail deve ser válido")
    @field:NotBlank(message = "O e-mail é obrigatório")
    var email: String,

    @field:NotBlank(message = "A senha é obrigatória")
    @field:Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    val password: String
)