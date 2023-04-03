package com.vinicius.forum.api.mapper

import com.vinicius.forum.api.model.Topic
import com.vinicius.forum.api.controller.input.TopicInput
import com.vinicius.forum.api.service.CourseService
import com.vinicius.forum.api.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicInputMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicInput, Topic> {
    override fun map(it: TopicInput): Topic {
        return Topic(
            title = it.title,
            message = it.message,
            course = courseService.findById(it.courseId),
            user = userService.findById(it.authorId)
        )
    }
}