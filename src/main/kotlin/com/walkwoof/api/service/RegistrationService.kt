package com.walkwoof.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.walkwoof.api.dto.UserRegisterDto
import com.walkwoof.api.entity.User
import com.walkwoof.api.entity.Walker
import com.walkwoof.api.repository.UserRepository
import com.walkwoof.api.repository.WalkerRepository
import com.walkwoof.api.util.UserRole
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegistrationService(
    private val userRepository: UserRepository,
    private val walkerRepository: WalkerRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val objectMapper: ObjectMapper
) {

    @Transactional
    fun registerUser(userRegisterDto: UserRegisterDto): User {
        val encodedPassword = passwordEncoder.encode(userRegisterDto.password)

        val user = User(
            name = userRegisterDto.name,
            email = userRegisterDto.email,
            userPassword = encodedPassword,
            role = userRegisterDto.role,
            profilePic = userRegisterDto.profilePic ?: ""
        )

        val savedUser = userRepository.save(user)

        if (userRegisterDto.role == UserRole.WALKER) {
            val availabilityString = objectMapper.writeValueAsString(userRegisterDto.availability)
            val walker = Walker(
                availability = availabilityString,
                user = savedUser
            )
            walkerRepository.save(walker)
        }

        return savedUser
    }
}