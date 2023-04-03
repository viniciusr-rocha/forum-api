package com.vinicius.forum.api.model

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tb_answer")
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val message: String,
    val createdAt: Instant = Instant.now(),

    @ManyToOne
    val author: User,

    @ManyToOne
    val topic: Topic,
    val isSolved: Boolean,
)