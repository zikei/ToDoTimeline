package com.example.todo.domain.service

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline
import com.example.todo.ui.form.TlInfo
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

/** Timeline関連処理クラス */
interface TimelineService {
    /** timelineの取得 */
    fun getList(userId: Int): List<Timeline>

    /** タスクIDからtimelineの取得 */
    fun getListByTask(taskId: Int): List<Timeline>

    /** ログIDからtimelineの取得 */
    fun getTimelineById(logId: Int): Timeline?

    /**
     * 投稿
     * @return 登録ID
     */
    fun thinkingLogPost(post: Thinkinglog): Int

    /** タイムラインのsse登録 */
    fun sseTimelineRegister(userId: Int, taskId: Int?): SseEmitter

    /** メッセージの通知 */
    fun notifyMessage(userId: Int, taskId: Int?, msg: TlInfo)
}