package com.example.todo.domain.service

import com.example.todo.domain.model.Timeline

/** Timeline関連処理クラス */
interface TimelineService {
    /** timelineの取得 */
    fun getList(userId: Int): List<Timeline>
}