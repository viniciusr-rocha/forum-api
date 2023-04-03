package com.vinicius.forum.api.controller.handler.output

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.Instant

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorOutput(
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val error: String,
    val message: String? = null,
    val path: String,
    val fields: HashMap<String, String?>? = null,
)