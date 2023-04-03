package com.vinicius.forum.api.exceptions

class TopicNotFoundException(
    message: String? = "Tópico não encontrado.",
    cause: Throwable? = null,
) : NoStackTraceException(message, cause)