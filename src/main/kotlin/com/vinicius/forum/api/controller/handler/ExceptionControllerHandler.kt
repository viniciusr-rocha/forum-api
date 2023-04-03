package com.vinicius.forum.api.controller.handler

import com.vinicius.forum.api.controller.handler.output.ErrorOutput
import com.vinicius.forum.api.exceptions.TopicNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerHandler {

    @ExceptionHandler(TopicNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handlerNotFound(
        exception: TopicNotFoundException,
        request: HttpServletRequest,
    ): ErrorOutput {
        return ErrorOutput(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}