package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Course
import com.vinicius.forum.api.service.CurseService
import org.springframework.stereotype.Service

@Service
class CurseServiceImpl(
    private var curs: List<Course>,
) : CurseService {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        this.curs = listOf(course)
    }

    override fun findById(id: Long): Course {
        return this.curs.first { it.id == id }
    }
}