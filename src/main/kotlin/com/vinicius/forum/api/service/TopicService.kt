package com.vinicius.forum.api.service

import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.controller.input.UpdateTopicInput
import com.vinicius.forum.api.controller.output.projection.TopicByCategoryOutput
import com.vinicius.forum.api.controller.output.TopicOutput
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicService {
    fun listAll(courseName: String?, pagination: Pageable): Page<TopicOutput>

    fun findById(id: Long): TopicOutput

    fun insert(topicInput: TopicInput): TopicOutput

    fun update(updateTopicInput: UpdateTopicInput)

    fun delete(id: Long)

    fun report(): List<TopicByCategoryOutput>
}