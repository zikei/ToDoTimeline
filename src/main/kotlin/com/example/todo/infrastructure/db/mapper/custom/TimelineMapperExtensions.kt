package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog
import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from

private val columnList = listOf(
    Thinkinglog.logid,
    Thinkinglog.taskid,
    Task.taskname,
    Thinkinglog.userid,
    Thinkinglog.createdate,
    Thinkinglog.contents
)

fun TimelineMapper.select(): List<TodoRecord> {
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByPrimaryKey(id: Int): TodoRecord? {
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
        where(Thinkinglog.logid, isEqualTo(id))
    }
    return selectOne(selectStatement)
}
