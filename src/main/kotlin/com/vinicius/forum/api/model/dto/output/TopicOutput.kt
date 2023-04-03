package com.vinicius.forum.api.model.dto.output

import com.vinicius.forum.api.model.enums.TopicStatus
import java.time.Instant

data class TopicOutput(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: Instant,
)