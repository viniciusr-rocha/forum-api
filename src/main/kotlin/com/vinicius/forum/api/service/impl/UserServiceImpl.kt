package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.User
import com.vinicius.forum.api.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private var users: List<User>,
) : UserService {

    init {
        val user = User(
            id = 1,
            name = "Kotlin",
            email = "user@email.com"
        )
        this.users = listOf(user)
    }

    override fun findById(id: Long): User {
        return this.users.first { it.id == id }
    }
}