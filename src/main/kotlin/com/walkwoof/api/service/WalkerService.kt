package com.walkwoof.api.service

import com.walkwoof.api.entity.Walker
import com.walkwoof.api.repository.WalkerRepository
import org.springframework.stereotype.Service

@Service
class WalkerService(val walkerRepository: WalkerRepository) {

    fun getByUserId(userId: Long): Walker {
        return walkerRepository.findByUserId(userId)
    }
}