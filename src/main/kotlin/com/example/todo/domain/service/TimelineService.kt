package com.example.todo.domain.service

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline

/** Timeline関連処理クラス */
interface TimelineService {
    /** timelineの取得 */
    fun getList(userId: Int): List<Timeline>

    /**
     * 投稿
     * @return 登録ID
     */
    fun thinkingLogPost(post: Thinkinglog): Int
}