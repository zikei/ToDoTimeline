package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.mapper.custom.ParentTaskDynamicSqlSupport.PTask
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from

private val columnList = listOf(
    Task.taskid,
    Task.userid,
    Task.taskname,
    Task.memo,
    Task.createdate,
    Task.severity,
    Task.deadline,
    Task.taskstatus,

    PTask.taskid.`as`("ptaskid"),
    PTask.userid.`as`("puserid"),
    PTask.taskname.`as`("ptaskname"),
    PTask.memo.`as`("pmemo"),
    PTask.createdate.`as`("pcreatedate"),
    PTask.severity.`as`("pseverity"),
    PTask.deadline.`as`("pdeadline"),
    PTask.taskstatus.`as`("ptaskstatus")

)

fun TodoMapper.select(): List<TodoRecord> {
    val selectStatement = select(columnList).from(Task) {
        leftJoin(PTask, "p") {
            on(Task.parentid, equalTo(PTask.taskid))
        }
    }
    return selectMany(selectStatement)
}

fun TodoMapper.selectByUserId(id : Int): List<TodoRecord>{
    val selectStatement = select(columnList).from(Task) {
        leftJoin(PTask, "p") {
            on(Task.parentid, equalTo(PTask.taskid))
        }
        where(Task.userid, isEqualTo(id))
    }
    return selectMany(selectStatement)
}

fun TodoMapper.selectByPrimaryKey(id: Int): TodoRecord? {
    val selectStatement = select(columnList).from(Task) {
        leftJoin(PTask, "p") {
            on(Task.parentid, equalTo(PTask.taskid))
        }
        where(Task.taskid, isEqualTo(id))
    }
    return selectOne(selectStatement)
}
