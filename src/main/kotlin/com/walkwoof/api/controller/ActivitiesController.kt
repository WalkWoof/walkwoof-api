package com.walkwoof.api.controller

import com.walkwoof.api.dto.ActivityDto
import com.walkwoof.api.service.ActivityService
import com.walkwoof.api.service.UserService
import com.walkwoof.api.service.WalkerService
import com.walkwoof.api.util.ActivityStatus
import com.walkwoof.api.util.UserRole
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/activities")
class ActivitiesController(
    val activityService: ActivityService,
    val userService: UserService,
    val walkerService: WalkerService
) {

    @GetMapping("/active")
    fun getActiveActivities(): ResponseEntity<List<ActivityDto>> {
        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val user = userService.findByEmail(userDetails.username)

        val activities =  if (user!!.role == UserRole.WALKER) {
            val walker = walkerService.getByUserId(user.id)
            activityService.getWalkerActivities(walker.id).filter { it.status == ActivityStatus.IN_PROGRESS }
        } else {
            activityService.getUserActivities(user.id).filter { it.status == ActivityStatus.IN_PROGRESS }
        }

        val activitiesDtos = activities.map { activity ->
            ActivityDto(
                id = activity.id.toString(),
                status = activity.status.toString(),
                startTime = activity.startTime.toString(),
                endTime = activity.endTime.toString(),
                createdAt = activity.createdAt.toString(),
                updatedAt = activity.updatedAt.toString(),
                walker = activity.walker!!.user!!.name,
                pet = activity.pet!!.name
            )
        }

        return ResponseEntity.ok(activitiesDtos)
    }

    @GetMapping("/history")
    fun getActivitiesHistory(): ResponseEntity<List<ActivityDto>> {
        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val user = userService.findByEmail(userDetails.username)

        val activities =  if (user!!.role == UserRole.WALKER) {
            val walker = walkerService.getByUserId(user.id)
            activityService.getWalkerActivities(walker.id)
        } else {
            activityService.getUserActivities(user.id)
        }

        val activitiesDtos = activities.map { activity ->
            ActivityDto(
                id = activity.id.toString(),
                status = activity.status.toString(),
                startTime = activity.startTime.toString(),
                endTime = activity.endTime.toString(),
                createdAt = activity.createdAt.toString(),
                updatedAt = activity.updatedAt.toString(),
                walker = activity.walker!!.user!!.name,
                pet = activity.pet!!.name
            )
        }

        return ResponseEntity.ok(activitiesDtos)
    }
}