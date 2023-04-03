package com.vinicius.forum.api.service.impl

import com.vinicius.forum.api.model.Curse
import com.vinicius.forum.api.service.CurseService
import org.springframework.stereotype.Service

@Service
class CurseServiceImpl(
    private var curses: List<Curse>,
) : CurseService {

    init {
        val curse = Curse(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        this.curses = listOf(curse)
    }

    override fun findById(id: Long): Curse {
        return this.curses.first { it.id == id }
    }
}