package com.vinicius.forum.api.exceptions

open class NoStackTraceException(
    message: String?,
    cause: Throwable?,
) : RuntimeException(message, cause, true, false)