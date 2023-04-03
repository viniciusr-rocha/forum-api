package com.vinicius.forum.api.model

import com.vinicius.forum.api.model.enums.User
import java.time.Instant

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val curse: Curse,
    val user: User,
    val answers: List<Answer> = ArrayList(),
    val createdAt: Instant = Instant.now(),
)