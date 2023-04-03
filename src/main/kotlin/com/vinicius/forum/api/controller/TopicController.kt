package com.vinicius.forum.api.controller

import com.vinicius.forum.api.model.dto.input.TopicInput
import com.vinicius.forum.api.model.dto.output.TopicOutput
import com.vinicius.forum.api.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun listAll(): List<TopicOutput> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicOutput {
        return service.findById(id)
    }

    @PostMapping
    fun insert(@RequestBody topic: TopicInput) {
        return service.insert(topic)
    }
}