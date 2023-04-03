package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.TopicDTO

interface TopicService {
    fun listAll(): List<Topic>

    fun findById(id: Long): Topic

    fun insert(topic: TopicDTO): TopicDTO
}