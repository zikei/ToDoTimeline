package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import org.mybatis.dynamic.sql.AliasableSqlTable
import java.sql.JDBCType
import java.time.LocalDate

object ParentTaskDynamicSqlSupport {
    val ptask = PTask()
    val ptaskid = ptask.taskid
    val puserid = ptask.userid
    val ptaskname = ptask.taskname
    val pmemo = ptask.memo
    val pcreatedate = ptask.createdate
    val pseverity = ptask.severity
    val pdeadline = ptask.deadline
    val ptaskstatus = ptask.taskstatus
    val pparentid = ptask.parentid

    class PTask : AliasableSqlTable<Task>("task", ::Task) {
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