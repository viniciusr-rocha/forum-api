package com.vinicius.forum.api.repository

import com.vinicius.forum.api.controller.output.projection.TopicByCategoryOutput
import com.vinicius.forum.api.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String?, pagination: Pageable): Page<Topic>

    @Query(
        """
        select tc.category     as category,
               count(tc.category) as quantity
        from tb_topic tt
                 join tb_course tc on tc.id = tt.course_id
        group by tc.category
    """, nativeQuery = true
    )
    fun report(): List<TopicByCategoryOutput>
}