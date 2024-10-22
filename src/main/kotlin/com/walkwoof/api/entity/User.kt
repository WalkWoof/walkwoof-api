package com.walkwoof.api.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username")
    val name: String = "",
    @Column(unique = true)
    val email: String = "",
    @Column(name = "password")
    val userPassword: String = "",
    @Column
    val role: String = "",
    @Column(name = "profile_picture_url")
    val profilePic: String = ""
): UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf(SimpleGrantedAuthority(role))
    }

    override fun getPassword(): String {
        return userPassword
    }

    override fun getUsername(): String {
        return email
    }

}