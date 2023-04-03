package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.input.TopicInput
import com.vinicius.forum.api.model.dto.output.TopicOutput
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

    override fun listAll(): List<TopicOutput> {
        return this.topics.map {
            TopicOutput(
                id = it.id,
                title = it.title,
                message = it.message,
                status = it.status,
                createdAt = it.createdAt
            )
        }
    }

    override fun findById(id: Long): TopicOutput {
        return this.topics.filter { it.id == id }
            .map {
                TopicOutput(
                    id = it.id,
                    title = it.title,
                    message = it.message,
                    status = it.status,
                    createdAt = it.createdAt
                )
            }
            .first()
    }

    override fun insert(topic: TopicInput) {
        this.topics = listOf(
            Topic(
                id = this.topics.size.toLong() + 1,
                title = topic.title,
                message = topic.message,
                curse = curseService.findById(topic.curseId),
                user = userService.findById(topic.authorId)
            ),
        )
    }
}