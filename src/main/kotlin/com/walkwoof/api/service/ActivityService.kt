package com.walkwoof.api.service

import com.walkwoof.api.entity.Activity
import com.walkwoof.api.repository.ActivityRepository
import org.springframework.stereotype.Service
import org.slf4j.*

@Service
class ActivityService(val activityRepository: ActivityRepository) {

    private val logger = LoggerFactory.getLogger(ActivityService::class.java)

    fun getWalkerActivities(walkerId: Long): List<Activity> {
        logger.info("Buscando atividades em progresso para Walker com ID: $walkerId")
        val activities = activityRepository.findByWalkerId(walkerId)
        logger.info("Atividades encontradas: ${activities.size}")
        return activities
    }

    fun getUserActivities(userId: Long): List<Activity> {
        return activityRepository.findByUserId(userId)
    }
}