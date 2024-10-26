package com.walkwoof.api.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "pets")
data class Pet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column
    val breed: String = "",

    @Column
    val age: Int = 0,

    @Column(name = "created_at", updatable = false)
    val createdAt: Timestamp? = null,

    @Column(name = "updated_at")
    var updatedAt: Timestamp? = null,

    @OneToOne
    @JoinColumn(name = "owner_id", nullable = false)
    val owner: User? = null
)
