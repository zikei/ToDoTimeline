package com.example.todo.ui.form

import com.example.todo.domain.enums.Role
import com.example.todo.domain.model.Timeline
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.format.DateTimeFormatter

private val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

/** タイムライン返却 */
data class GetTlListResponse(val tlList: List<TlInfo>)

/** 投稿登録要求 */
data class RegisterPostRequest(
    var taskid: Int?,
    @get:NotBlank
    @get:Size(min = 1, max = 500)
    var contents: String?
) {
    constructor() : this(null, null)
}

/** タイムライン情報 */
data class TlInfo(
    var logid: Int,
    var userid: Int,
    var isSysUser: Boolean,
    var dspname: String,
    var taskid: Int?,
    var taskname: String?,
    var createdate: String,
    var contents: String
) {
    constructor(tl: Timeline) : this(
        tl.logid!!, tl.userid, (tl.role == Role.SYSTEM), tl.dspname, tl.taskid, tl.taskname, tl.createdate.format(dateTimeFormat), tl.contents
    )
}