package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.controller.input.UpdateTopicInput
import com.vinicius.forum.api.controller.output.TopicOutput
import com.vinicius.forum.api.exceptions.NotFoundException
import com.vinicius.forum.api.mapper.TopicInputMapper
import com.vinicius.forum.api.mapper.TopicOutputMapper
import com.vinicius.forum.api.repository.TopicRepository
import com.vinicius.forum.api.service.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var repository: TopicRepository,
    private val topicOutputMapper: TopicOutputMapper,
    private val topicInputMapper: TopicInputMapper,
) : TopicService {

    override fun listAll(courseName: String?, pagination: Pageable): Page<TopicOutput> {
        val topics = if (courseName.isNullOrBlank()) {
            repository.findAll(pagination)
        } else {
            repository.findByCourseName(courseName, pagination)
        }
        return topics.map { topicOutputMapper.map(it) }
    }

    override fun findById(id: Long): TopicOutput {
        val topic = findTopicById(id)
        return topicOutputMapper.map(topic)
    }

    override fun insert(topicInput: TopicInput): TopicOutput {
        val topic = topicInputMapper.map(topicInput)
        repository.save(topic)
        return topicOutputMapper.map(topic)
    }

    override fun update(updateTopicInput: UpdateTopicInput) {
        val topic = findTopicById(updateTopicInput.id)
        val topicUpdated = topic.copy(
            title = updateTopicInput.title,
            message = updateTopicInput.message
        )
        repository.save(topicUpdated)
    }

    override fun delete(id: Long) {
        findTopicById(id)
        repository.deleteById(id)
    }

    private fun findTopicById(id: Long) = this.repository
        .findByIdOrNull(id) ?: throw NotFoundException("Tópico inexistente.")
}