package com.example.todo.domain.repository

import com.example.todo.domain.model.Timeline

interface TimelineRepository {
    /** ユーザIDからユーザのTodoのListを取得 */
    fun findListByUserId(userId: Int): List<Timeline>
}