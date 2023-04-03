package com.vinicius.forum.api.exceptions

open class NoStackTraceException(
    message: String?,
) : RuntimeException(message, null, true, false)