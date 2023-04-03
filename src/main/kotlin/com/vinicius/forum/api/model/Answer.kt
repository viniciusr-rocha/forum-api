package com.vinicius.forum.api.model

import com.vinicius.forum.api.model.enums.User
import java.time.Instant

data class Answer(
    val id: Long?,
    val message: String,
    val createdAt: Instant = Instant.now(),
    val author: User,
    val topic: Topic,
    val isSolved: Boolean,
)