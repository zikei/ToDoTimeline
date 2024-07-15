package com.example.todo.infrastructure.db.record.custom

import com.example.todo.domain.enums.Role
import java.time.LocalDateTime

data class TimelineRecord (
    // 思考ログ
    var logid: Int? = null,
    var taskid: Int? = null,
    var userid: Int? = null,
    var createdate: LocalDateTime? = null,
    var contents: String? = null,

    // タスク
    var taskname: String? = null,

    // ユーザ
    var dspname: String? = null,
    var role: Role? = null
)