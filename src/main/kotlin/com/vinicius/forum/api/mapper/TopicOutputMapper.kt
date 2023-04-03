package com.vinicius.forum.api.mapper

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.output.TopicOutput
import org.springframework.stereotype.Component

@Component
class TopicOutputMapper : Mapper<Topic, TopicOutput> {
    override fun map(it: Topic): TopicOutput {
        return TopicOutput(
            id = it.id,
            title = it.title,
            message = it.message,
            status = it.status,
            createdAt = it.createdAt
        )
    }
}