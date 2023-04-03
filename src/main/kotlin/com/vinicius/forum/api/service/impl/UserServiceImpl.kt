package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.exceptions.NotFoundException
import com.vinicius.forum.api.model.User
import com.vinicius.forum.api.repository.UserRepository
import com.vinicius.forum.api.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val repository: UserRepository,
) : UserService {

    override fun findById(id: Long): User {
        return this.repository.findByIdOrNull(id) ?: throw NotFoundException("Usuário inexiste.")
    }
}