package com.example.todo.domain.repository

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline

interface TimelineRepository {
    /** ユーザIDから投稿のListを取得 */
    fun findListByUserId(userId: Int): List<Timeline>

    /** タスクIDから投稿のListを取得 */
    fun findListByTaskId(taskId: Int): List<Timeline>

    /**
     * 投稿の登録
     * @return 登録ID
     */
    fun insertPost(post: Thinkinglog): Int
}