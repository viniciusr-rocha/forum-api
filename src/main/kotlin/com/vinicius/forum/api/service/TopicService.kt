package com.vinicius.forum.api.service

import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.controller.input.UpdateTopicInput
import com.vinicius.forum.api.controller.output.TopicOutput

interface TopicService {
    fun listAll(): List<TopicOutput>

    fun findById(id: Long): TopicOutput

    fun insert(topicInput: TopicInput): TopicOutput

    fun update(updateTopicInput: UpdateTopicInput)

    fun delete(id: Long)
}