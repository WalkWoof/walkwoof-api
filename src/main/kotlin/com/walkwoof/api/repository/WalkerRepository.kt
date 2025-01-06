package com.walkwoof.api.repository

import com.walkwoof.api.entity.Walker
import org.springframework.data.jpa.repository.JpaRepository

interface WalkerRepository : JpaRepository<Walker, Long> {

    fun findByUserId(userId: Long): Walker
}