package com.walkwoof.api.repository

import com.walkwoof.api.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ActivityRepository : JpaRepository<Activity, Long> {

    fun findByWalkerId(walkerId: Long): List<Activity>

    @Query("SELECT a FROM Activity a JOIN a.pet p WHERE p.owner.id = :userId")
    fun findByUserId(@Param("userId") userId: Long): List<Activity>
}