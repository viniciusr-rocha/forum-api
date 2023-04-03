package com.vinicius.forum.api.model

import com.vinicius.forum.api.model.enums.TopicStatus
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tb_topic")
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val message: String,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,

    @ManyToOne
    val course: Course,

    @ManyToOne
    val user: User,

    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList(),

    val createdAt: Instant = Instant.now(),
)