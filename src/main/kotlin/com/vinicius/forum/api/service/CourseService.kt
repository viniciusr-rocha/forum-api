package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.Course

interface CourseService {
    fun findById(id: Long): Course
}
