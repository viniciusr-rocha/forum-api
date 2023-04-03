package com.vinicius.forum.api.controller.output.projection

interface TopicByCategoryOutput {
    fun getCategory(): String
    fun getQuantity(): Long
}