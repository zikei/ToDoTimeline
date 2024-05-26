package com.example.todo.domain.repository

import com.example.todo.domain.model.Todo

interface TodoRepository {
    fun findListByUserId(userId: Int): List<Todo>
}