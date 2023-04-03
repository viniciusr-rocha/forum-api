package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Curse
import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.User
import com.vinicius.forum.api.service.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl : TopicService {
    override fun listAll(): List<Topic> {
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
        return listOf(topic)
    }
}