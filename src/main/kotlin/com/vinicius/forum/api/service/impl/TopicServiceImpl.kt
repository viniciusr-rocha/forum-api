package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.exceptions.TopicNotFoundException
import com.vinicius.forum.api.mapper.TopicInputMapper
import com.vinicius.forum.api.mapper.TopicOutputMapper
import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.controller.input.UpdateTopicInput
import com.vinicius.forum.api.controller.output.TopicOutput
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
            .firstOrNull() ?: throw TopicNotFoundException()
    }

    override fun insert(topicInput: TopicInput): TopicOutput {
        val topic = topicInputMapper
            .map(topicInput)
            .copy(id = this.topics.size.toLong() + 1)
        this.topics = topics.plus(topic)
        return topicOutputMapper.map(topic)
    }

    override fun update(updateTopicInput: UpdateTopicInput) {
        val topic = findTopic(updateTopicInput.id)
        this.topics = topics
            .minus(topic)
            .plus(
                Topic(
                    id = updateTopicInput.id,
                    title = updateTopicInput.title,
                    message = updateTopicInput.message,
                    user = topic.user,
                    course = topic.course,
                    answers = topic.answers,
                    status = topic.status,
                    createdAt = topic.createdAt
                )
            )
    }

    override fun delete(id: Long) {
        val topic = findTopic(id)
        this.topics = topics.minus(topic)
    }

    private fun findTopic(id: Long) = this.topics
        .find { it.id == id } ?: throw TopicNotFoundException()
}