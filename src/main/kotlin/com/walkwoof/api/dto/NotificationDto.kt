package com.walkwoof.api.dto

data class NotificationDto(
    val id: String,
    val type: String,
    val message: String,
    val createdAt: String
)
