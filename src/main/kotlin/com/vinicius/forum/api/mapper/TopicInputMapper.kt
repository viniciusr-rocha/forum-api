package com.vinicius.forum.api.mapper

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.service.CurseService
import com.vinicius.forum.api.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicInputMapper(
    private val curseService: CurseService,
    private val userService: UserService,
) : Mapper<TopicInput, Topic> {
    override fun map(it: TopicInput): Topic {
        return Topic(
            title = it.title,
            message = it.message,
            curse = curseService.findById(it.curseId),
            user = userService.findById(it.authorId)
        )
    }
}