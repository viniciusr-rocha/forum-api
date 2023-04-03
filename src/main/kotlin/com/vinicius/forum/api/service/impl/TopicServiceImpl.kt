package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.TopicDTO
import com.vinicius.forum.api.service.CurseService
import com.vinicius.forum.api.service.TopicService
import com.vinicius.forum.api.service.UserService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic> = ArrayList(),
    private val curseService: CurseService,
    private val userService: UserService,
) : TopicService {

    override fun listAll(): List<Topic> {
        return this.topics
    }

    override fun findById(id: Long): Topic {
        return this.topics.first { it.id == id }
    }

    override fun insert(topic: TopicDTO): TopicDTO {
        this.topics.plus(
            Topic(
                id = this.topics.size.toLong() + 1,
                title = topic.title,
                message = topic.message,
                curse = curseService.findById(topic.curseId),
                user = userService.findById(topic.authorId)
            ),
        )
        return topic
    }
}