package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.Topic

interface TopicService {
    fun listAll(): List<Topic>
    fun findById(id: Long): Topic
}