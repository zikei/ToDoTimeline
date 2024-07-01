package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User
import com.example.todo.infrastructure.db.record.custom.TimelineRecord
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from

private val columnList = listOf(
    Thinkinglog.logid,
    Thinkinglog.taskid,
    Task.taskname,
    Thinkinglog.userid,
    User.dspname,
    Thinkinglog.createdate,
    Thinkinglog.contents
)

fun TimelineMapper.select(): List<TimelineRecord> {
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
        leftJoin(User) {
            on(Thinkinglog.userid, equalTo(User.userid))
        }
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByUserId(id : Int): List<TimelineRecord>{
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
        leftJoin(User) {
            on(Thinkinglog.userid, equalTo(User.userid))
        }
        where(Thinkinglog.userid, isEqualTo(id))
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByTaskId(id: Int): List<TimelineRecord>{
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
        leftJoin(User) {
            on(Thinkinglog.userid, equalTo(User.userid))
        }
        where(Thinkinglog.taskid, isEqualTo(id))
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByPrimaryKey(id: Int): TimelineRecord? {
    val selectStatement = select(columnList).from(Thinkinglog) {
        leftJoin(Task) {
            on(Thinkinglog.taskid, equalTo(Task.taskid))
        }
        leftJoin(User) {
            on(Thinkinglog.userid, equalTo(User.userid))
        }
        where(Thinkinglog.logid, isEqualTo(id))
    }
    return selectOne(selectStatement)
}
