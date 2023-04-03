package com.vinicius.forum.api.model.dto.input

data class TopicInput(
    val title: String,
    val message: String,
    val curseId: Long,
    val authorId: Long,
)