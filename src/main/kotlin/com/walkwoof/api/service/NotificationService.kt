package com.walkwoof.api.service

import com.walkwoof.api.entity.Notification
import com.walkwoof.api.repository.NotificationRepository
import org.springframework.stereotype.Service

@Service
class NotificationService(val notificationRepository: NotificationRepository) {

    fun getNotificationsForUser(userId: Long): List<Notification> {
        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId)
    }
}