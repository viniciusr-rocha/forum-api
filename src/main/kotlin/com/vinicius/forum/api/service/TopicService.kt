package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.dto.input.TopicInput
import com.vinicius.forum.api.model.dto.input.UpdateTopicInput
import com.vinicius.forum.api.model.dto.output.TopicOutput

interface TopicService {
    fun listAll(): List<TopicOutput>

    fun findById(id: Long): TopicOutput

    fun insert(topicInput: TopicInput): TopicOutput

    fun update(updateTopicInput: UpdateTopicInput)

    fun delete(id: Long)
}