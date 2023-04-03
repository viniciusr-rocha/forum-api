package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.Course

interface CurseService {
    fun findById(id: Long): Course
}
