package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.User
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val user: User,
) : UserDetails {
    override fun getAuthorities() = this.user.roles

    override fun getPassword() = this.user.password

    override fun getUsername() = this.user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}