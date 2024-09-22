package com.walkwoof.api.util

import io.jsonwebtoken.security.Keys
import java.security.Key

class JwtKey(private val secret: String) {

    private val key: Key by lazy {
        Keys.hmacShaKeyFor(secret.toByteArray())
    }

    fun receiveKey(): Key {
        return key
    }
}