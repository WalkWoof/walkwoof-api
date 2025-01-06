package com.walkwoof.api.entity

import com.walkwoof.api.util.ActivityStatus
import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "activities")
data class Activity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: ActivityStatus = ActivityStatus.SCHEDULED,

    @Column(name = "start_time", nullable = false)
    val startTime: Timestamp? = null,

    @Column(name = "end_time")
    val endTime: Timestamp? = null,

    @Column(name = "created_at", updatable = false)
    val createdAt: Timestamp? = null,

    @Column(name = "updated_at")
    var updatedAt: Timestamp? = null,

    @OneToOne
    @JoinColumn(name = "walker_id", nullable = false)
    val walker: Walker? = null,

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    val pet: Pet? = null
)
