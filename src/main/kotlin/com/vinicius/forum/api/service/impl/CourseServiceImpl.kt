package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.exceptions.NotFoundException
import com.vinicius.forum.api.model.Course
import com.vinicius.forum.api.repository.CourseRepository
import com.vinicius.forum.api.service.CourseService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
    private val repository: CourseRepository,
) : CourseService {

    override fun findById(id: Long): Course {
        return this.repository.findByIdOrNull(id) ?: throw NotFoundException("Curso inexistente.")
    }
}