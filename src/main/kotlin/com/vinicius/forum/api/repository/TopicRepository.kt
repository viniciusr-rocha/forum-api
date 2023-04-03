package com.vinicius.forum.api.repository

import com.vinicius.forum.api.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String?): List<Topic>
}