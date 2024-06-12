package com.example.todo.infrastructure.db.record.custom

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import java.time.LocalDate

data class TodoRecord (
    //タスク
    var taskid: Int? = null,
    var userid: Int? = null,
    var taskname: String? = null,
    var memo: String? = null,
    var createdate: LocalDate? = null,
    var severity: Severity? = null,
    var deadline: LocalDate? = null,
    var taskstatus: TaskStatus? = null,

    //親タスク
    var ptaskid: Int? = null,
    var puserid: Int? = null,
    var ptaskname: String? = null,
    var pmemo: String? = null,
    var pcreatedate: LocalDate? = null,
    var pseverity: Severity? = null,
    var pdeadline: LocalDate? = null,
    var ptaskstatus: TaskStatus? = null
)