package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.mapper.TopicInputMapper
import com.vinicius.forum.api.mapper.TopicOutputMapper
import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.input.TopicInput
import com.vinicius.forum.api.model.dto.input.UpdateTopicInput
import com.vinicius.forum.api.model.dto.output.TopicOutput
import com.vinicius.forum.api.service.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic> = ArrayList(),
    private val topicOutputMapper: TopicOutputMapper,
    private val topicInputMapper: TopicInputMapper,
) : TopicService {

    override fun listAll(): List<TopicOutput> {
        return this.topics.map { topicOutputMapper.map(it) }
    }

    override fun findById(id: Long): TopicOutput {
        return this.topics.filter { it.id == id }
            .map { topicOutputMapper.map(it) }
            .first()
    }

    override fun insert(topicInput: TopicInput) {
        this.topics = topics.plus(
            topicInputMapper.map(topicInput)
                .copy(id = this.topics.size.toLong() + 1)
        )
    }

    override fun update(updateTopicInput: UpdateTopicInput) {
        val topic = this.topics.first { it.id == updateTopicInput.id }
        this.topics = topics
            .minus(topic)
            .plus(
                Topic(
                    id = updateTopicInput.id,
                    title = updateTopicInput.title,
                    message = updateTopicInput.message,
                    user = topic.user,
                    curse = topic.curse,
                    answers = topic.answers,
                    status = topic.status,
                    createdAt = topic.createdAt
                )
            )
    }
}