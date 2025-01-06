package com.walkwoof.api.service

import com.walkwoof.api.entity.User
import com.walkwoof.api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}