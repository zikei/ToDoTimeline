package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import org.mybatis.dynamic.sql.SqlTable
import java.sql.JDBCType
import java.time.LocalDate

object ParentTaskDynamicSqlSupport {
    object PTask : SqlTable("task") {
        val taskid = column<Int>("taskId", JDBCType.INTEGER)

        val userid = column<Int>("userId", JDBCType.INTEGER)

        val taskname = column<String>("taskName", JDBCType.VARCHAR)

        val memo = column<String>("memo", JDBCType.VARCHAR)

        val createdate = column<LocalDate>("createDate", JDBCType.DATE)

        val severity = column<Severity>("severity", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val deadline = column<LocalDate>("deadline", JDBCType.DATE)

        val taskstatus = column<TaskStatus>("taskStatus", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val parentid = column<Int>("parentId", JDBCType.INTEGER)
    }
}