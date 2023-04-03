package com.vinicius.forum.api.controller

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.model.dto.TopicDTO
import com.vinicius.forum.api.service.TopicService
import org.springframework.web.bind.annotation.*

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
    fun insert(@RequestBody topic: TopicDTO): TopicDTO {
        return service.insert(topic)
    }
}