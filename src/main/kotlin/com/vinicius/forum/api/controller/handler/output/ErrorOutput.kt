package com.vinicius.forum.api.controller.handler.output

import java.time.Instant

data class ErrorOutput(
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String,
)