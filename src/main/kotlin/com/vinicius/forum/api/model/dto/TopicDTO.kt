package com.vinicius.forum.api.model.dto

data class TopicDTO(
    val title: String,
    val message: String,
    val curseId: Long,
    val authorId: Long,
)