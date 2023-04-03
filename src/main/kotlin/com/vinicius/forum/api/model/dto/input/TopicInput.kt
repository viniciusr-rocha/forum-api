package com.vinicius.forum.api.model.dto.input

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicInput(
    @field:NotEmpty(message = "O título é obrigatório.")
    @field:Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres.")
    val title: String,

    @field:NotEmpty(message = "A menssagem é obrigatória.")
    val message: String,

    @field:NotNull(message = "O identificado do curso é obrigatório.")
    val curseId: Long,

    @field:NotNull(message = "O identificado do autor é obrigatório.")
    val authorId: Long,
)