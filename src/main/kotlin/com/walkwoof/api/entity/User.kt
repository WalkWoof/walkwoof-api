package com.walkwoof.api.entity

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val email: String,
    val password: String,
    val role: String // Em breve será criada uma nova data class para a entidade Walker, com seus atributos específicos.
)