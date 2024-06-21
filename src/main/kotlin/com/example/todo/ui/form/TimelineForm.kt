package com.example.todo.ui.form

import com.example.todo.domain.model.Timeline
import java.time.LocalDateTime

/** タイムライン返却 */
data class GetTlListResponse(val tlList: List<TlInfo>)

/** タイムライン情報 */
data class TlInfo(
    var logid: Int,
    var userid: Int,
    var dspname: String,
    var taskid: Int?,
    var taskname: String?,
    var createdate: LocalDateTime,
    var contents: String
) {
    constructor(tl: Timeline) : this(
        tl.logid!!, tl.userid, tl.dspname, tl.taskid, tl.taskname, tl.createdate, tl.contents
    )
}