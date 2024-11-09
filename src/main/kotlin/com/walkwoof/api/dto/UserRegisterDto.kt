package com.walkwoof.api.dto

import com.walkwoof.api.util.UserRole

data class UserRegisterDto(
    val name: String,
    val email: String,
    val password: String,
    val role: UserRole,
    val profilePic: String? = null,
    val availability: Map<String, String>? = null
)
