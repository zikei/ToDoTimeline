package com.example.todo.ui.form

import com.example.todo.domain.model.Timeline
import java.time.format.DateTimeFormatter

private val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

/** タイムライン返却 */
data class GetTlListResponse(val tlList: List<TlInfo>)

/** タイムライン情報 */
data class TlInfo(
    var logid: Int,
    var userid: Int,
    var dspname: String,
    var taskid: Int?,
    var taskname: String?,
    var createdate: String,
    var contents: String
) {
    constructor(tl: Timeline) : this(
        tl.logid!!, tl.userid, tl.dspname, tl.taskid, tl.taskname, tl.createdate.format(dateTimeFormat), tl.contents
    )
}