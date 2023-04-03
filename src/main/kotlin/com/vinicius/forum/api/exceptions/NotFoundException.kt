package com.vinicius.forum.api.exceptions

class NotFoundException(
    message: String,
) : NoStackTraceException(message)