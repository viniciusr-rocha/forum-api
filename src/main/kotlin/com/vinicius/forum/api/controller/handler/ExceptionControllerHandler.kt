package com.vinicius.forum.api.controller.handler

import com.vinicius.forum.api.controller.handler.output.ErrorOutput
import com.vinicius.forum.api.exceptions.TopicNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TopicNotFoundException::class)
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

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handlerServerError(
        request: HttpServletRequest,
    ): ErrorOutput {
        return ErrorOutput(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = "Ocorreu um erro interno.",
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest,
    ): ErrorOutput {
        val message = HashMap<String, String?>()
        exception.bindingResult.fieldErrors
            .forEach {
                message[it.field] = it.defaultMessage
            }
        return ErrorOutput(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            path = request.servletPath,
            fields = message
        )
    }
}