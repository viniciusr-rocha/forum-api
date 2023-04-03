package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.User
import org.springframework.security.core.userdetails.UserDetailsService


interface UserService : UserDetailsService {
    fun findById(id: Long): User
}
