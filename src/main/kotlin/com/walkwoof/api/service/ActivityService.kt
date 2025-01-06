package com.walkwoof.api.service

import com.walkwoof.api.entity.Activity
import com.walkwoof.api.repository.ActivityRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(val activityRepository: ActivityRepository) {

    fun getWalkerActivities(walkerId: Long): List<Activity> {
        return activityRepository.findByWalkerId(walkerId)
    }

    fun getUserActivities(userId: Long): List<Activity> {
        return activityRepository.findByUserId(userId)
    }
}