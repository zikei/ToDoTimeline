/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.record

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import java.time.LocalDate

data class TaskRecord(
    var taskid: Int? = null,
    var userid: Int? = null,
    var taskname: String? = null,
    var memo: String? = null,
    var createdate: LocalDate? = null,
    var severity: Severity? = null,
    var deadline: LocalDate? = null,
    var taskstatus: TaskStatus? = null,
    var parentid: Int? = null
)