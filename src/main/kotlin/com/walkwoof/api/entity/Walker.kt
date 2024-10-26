package com.walkwoof.api.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp


@Entity
@Table(name = "walkers")
data class Walker(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val availability: String = "",

    @Column(precision = 3, scale = 2)
    val rating: BigDecimal = BigDecimal.ZERO,

    @Column(name = "created_at", updatable = false)
    val createdAt: Timestamp? = null,

    @Column(name = "updated_at")
    var updatedAt: Timestamp? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null

)
