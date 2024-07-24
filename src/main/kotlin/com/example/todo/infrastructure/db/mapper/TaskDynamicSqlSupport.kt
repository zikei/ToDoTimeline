/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType
import java.time.LocalDate

object TaskDynamicSqlSupport {
    val task = Task()

    val taskid = task.taskid

    val userid = task.userid

    val taskname = task.taskname

    val memo = task.memo

    val createdate = task.createdate

    val severity = task.severity

    val deadline = task.deadline

    val taskstatus = task.taskstatus

    val parentid = task.parentid

    class Task : AliasableSqlTable<Task>("task", ::Task) {
        val taskid = column<Int>(name = "taskId", jdbcType = JDBCType.INTEGER)

        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)

        val taskname = column<String>(name = "taskName", jdbcType = JDBCType.VARCHAR)

        val memo = column<String>(name = "memo", jdbcType = JDBCType.VARCHAR)

        val createdate = column<LocalDate>(name = "createDate", jdbcType = JDBCType.DATE)

        val severity = column<Severity>(name = "severity", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")

        val deadline = column<LocalDate>(name = "deadline", jdbcType = JDBCType.DATE)

        val taskstatus = column<TaskStatus>(name = "taskStatus", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")

        val parentid = column<Int>(name = "parentId", jdbcType = JDBCType.INTEGER)
    }
}