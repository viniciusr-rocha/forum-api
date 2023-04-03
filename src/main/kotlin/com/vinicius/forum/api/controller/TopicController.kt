package com.vinicius.forum.api.controller

import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.controller.input.UpdateTopicInput
import com.vinicius.forum.api.controller.output.TopicOutput
import com.vinicius.forum.api.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
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
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody @Valid topicInput: TopicInput): TopicOutput {
        return service.insert(topicInput)
    }

    @PutMapping
    fun update(@RequestBody @Valid topicInput: UpdateTopicInput) {
        service.update(topicInput)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}