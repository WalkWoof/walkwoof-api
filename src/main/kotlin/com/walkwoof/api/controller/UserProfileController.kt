package com.walkwoof.api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.walkwoof.api.dto.UserProfileDto
import com.walkwoof.api.entity.Walker
import com.walkwoof.api.service.UserService
import com.walkwoof.api.service.WalkerService
import com.walkwoof.api.util.UserRole
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserProfileController(
    private val userService: UserService,
    private val walkerService: WalkerService,
    private val objectMapper: ObjectMapper
) {

    @GetMapping("/profile")
    fun getUserProfile(): ResponseEntity<UserProfileDto> {

        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val user = userService.findByEmail(userDetails.username)
        var walker: Walker? = null

        if (user!!.role == UserRole.WALKER) {
            walker = walkerService.getByUserId(user.id)
        }

        val availabilityMap: Map<String, String>? = walker?.availability?.let {
            objectMapper.readValue(it, Map::class.java) as Map<String, String>
        }

        val userProfile = UserProfileDto(
            id = user.id.toString(),
            name = user.name,
            email = user.email,
            role = user.role.toString(),
            profilePic = user.profilePic,
            availability = availabilityMap
        )

        return ResponseEntity.ok(userProfile)
    }
}