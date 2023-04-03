package com.vinicius.forum.api.controller

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listAll(): List<Topic> {
        return service.listAll()
    }
}