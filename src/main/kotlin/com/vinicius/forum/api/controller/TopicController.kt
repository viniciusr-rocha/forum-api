package com.vinicius.forum.api.controller

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listAll(): List<Topic> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Topic {
        return service.findById(id)
    }

    @PostMapping
    fun insert(@RequestBody topic: Topic): Topic {
        return service.insert(topic)
    }
}