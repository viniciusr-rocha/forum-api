package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Curse
import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.User
import com.vinicius.forum.api.service.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic>,
) : TopicService {

    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            curse = Curse(
                1,
                "kotlin",
                "programcacao",
            ),
            user = User(
                1,
                "Kotlin",
                "kotlin@kotlin.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Duvida Kotlin 2",
            message = "Variaveis no Kotlin 2",
            curse = Curse(
                2,
                "kotlin 2",
                "programcacao 2",
            ),
            user = User(
                2,
                "Kotlin 2",
                "kotlin2@kotlin.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Duvida Kotlin 3",
            message = "Variaveis no Kotlin 3",
            curse = Curse(
                3,
                "kotlin 3",
                "programcacao 3",
            ),
            user = User(
                3,
                "Kotlin 3",
                "kotlin3@kotlin.com"
            )
        )
        this.topics = listOf(topic, topic2, topic3)
    }

    override fun listAll(): List<Topic> {
        return this.topics
    }

    override fun findById(id: Long): Topic {
        return this.topics.first { it.id == id }
    }
}