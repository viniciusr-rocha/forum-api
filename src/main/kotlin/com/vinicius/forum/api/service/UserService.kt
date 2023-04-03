package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.User


interface UserService {
    fun findById(id: Long): User
}
