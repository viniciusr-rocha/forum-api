package com.vinicius.forum.api.model.dto.input

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicInput(
    @NotNull(message = "O identificador do tópico é obrigatório.")
    val id: Long,

    @field:NotEmpty(message = "O título é obrigatório.")
    @field:Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres.")
    val title: String,

    @field:NotEmpty(message = "A menssagem é obrigatória.")
    val message: String,
)