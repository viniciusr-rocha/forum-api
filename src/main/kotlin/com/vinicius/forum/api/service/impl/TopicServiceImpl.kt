package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.service.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic> = ArrayList(),
) : TopicService {

    override fun listAll(): List<Topic> {
        return this.topics
    }

    override fun findById(id: Long): Topic {
        return this.topics.first { it.id == id }
    }

    override fun insert(topic: Topic): Topic {
        this.topics.plus(topic)
        return topic
    }
}