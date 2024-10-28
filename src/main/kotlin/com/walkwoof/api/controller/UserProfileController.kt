package com.walkwoof.api.controller

import com.walkwoof.api.dto.UserProfileDto
import com.walkwoof.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserProfileController(val userService: UserService) {

    @GetMapping("/profile")
    fun getUserProfile(): ResponseEntity<UserProfileDto> {

        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val user = userService.findByEmail(userDetails.username)

        val userProfile = UserProfileDto(
            id = user?.id.toString(),
            name = user?.name,
            email = user?.email,
            role = user?.role.toString(),
            profilePic = user?.profilePic
        )

        return ResponseEntity.ok(userProfile)
    }
}