package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.dto.input.TopicInput
import com.vinicius.forum.api.model.dto.output.TopicOutput

interface TopicService {
    fun listAll(): List<TopicOutput>

    fun findById(id: Long): TopicOutput

    fun insert(topic: TopicInput)
}