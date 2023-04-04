package com.vinicius.forum.api.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "tb_role")
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
) : GrantedAuthority {
    override fun getAuthority() = name
}