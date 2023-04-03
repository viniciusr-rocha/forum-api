package com.vinicius.forum.api.service

import com.vinicius.forum.api.model.Curse

interface CurseService {
    fun findById(id: Long): Curse
}
