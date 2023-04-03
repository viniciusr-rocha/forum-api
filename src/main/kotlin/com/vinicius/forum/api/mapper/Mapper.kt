package com.vinicius.forum.api.mapper

interface Mapper<T, U> {
    fun map(it: T): U
}
