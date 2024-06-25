package com.example.todo.domain.repository

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline

interface TimelineRepository {
    /** ユーザIDからユーザのTodoのListを取得 */
    fun findListByUserId(userId: Int): List<Timeline>

    /**
     * 投稿の登録
     * @return 登録ID
     */
    fun insertPost(post: Thinkinglog): Int
}