package com.walkwoof.api.controller

import com.walkwoof.api.dto.NotificationDto
import com.walkwoof.api.entity.Notification
import com.walkwoof.api.service.NotificationService
import com.walkwoof.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NotificationController(
    val notificationService: NotificationService,
    val userService: UserService
) {

    @GetMapping("/notifications")
    fun getNotifications(): ResponseEntity<List<NotificationDto>> {
        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val user = userService.findByEmail(userDetails.username)

        val notifications = notificationService.getNotificationsForUser(user!!.id)

        val notificationsDtos = notifications.map { notification ->
            NotificationDto(
                id = notification.id.toString(),
                type = notification.type,
                message = notification.message,
                createdAt = notification.createdAt.toString()
            )
        }

        return ResponseEntity.ok(notificationsDtos)
    }
}