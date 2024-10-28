package com.walkwoof.api.dto

data class ActivityDto(
    val id: String,
    val status: String,
    val startTime: String,
    val endTime: String,
    val createdAt: String,
    val updatedAt: String,
    val walker: String,
    val pet: String
)
