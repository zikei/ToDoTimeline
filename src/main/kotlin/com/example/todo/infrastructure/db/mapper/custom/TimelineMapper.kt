package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.record.custom.TimelineRecord
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport as Task
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.task as taskTable
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport as Thinkinglog
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.thinkinglog as thinkinglogTable
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport as User
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.user as userTable

@Mapper
interface TimelineMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "TimelineRecordResult", value = [
            Result(column="logId", property="logid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER),
            Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
            Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
            Result(column="role", property="role", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
            Result(column="dspName", property="dspname", jdbcType=JdbcType.VARCHAR),
            Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
            Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider) : List<TimelineRecord>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("TimelineRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider) : TimelineRecord?
}

private val columnList = listOf(
    Thinkinglog.logid,
    Task.taskid,
    Task.taskname,
    User.userid,
    User.dspname,
    User.role,
    Thinkinglog.createdate,
    Thinkinglog.contents
)

fun TimelineMapper.select(): List<TimelineRecord> {
    val selectStatement = select(columnList){
        from(thinkinglogTable)
        leftJoin(taskTable) {
            on(Thinkinglog.taskid,) equalTo(Task.taskid)
        }
        leftJoin(userTable) {
            on(Thinkinglog.userid) equalTo(User.userid)
        }
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByUserId(id : Int): List<TimelineRecord>{
    val selectStatement = select(columnList){
        from(thinkinglogTable)
        leftJoin(taskTable) {
            on(Thinkinglog.taskid,) equalTo(Task.taskid)
        }
        leftJoin(userTable) {
            on(Thinkinglog.userid) equalTo(User.userid)
        }
        where{ Thinkinglog.userid isEqualTo id }
        orderBy(Thinkinglog.createdate.descending())
    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByTaskId(id: Int): List<TimelineRecord>{
    val selectStatement = select(columnList){
        from(thinkinglogTable)
        leftJoin(taskTable) {
            on(Thinkinglog.taskid,) equalTo(Task.taskid)
        }
        leftJoin(userTable) {
            on(Thinkinglog.userid) equalTo(User.userid)
        }
        where { Thinkinglog.taskid isEqualTo id }
        orderBy(Thinkinglog.createdate.descending())

    }
    return selectMany(selectStatement)
}

fun TimelineMapper.selectByPrimaryKey(id: Int): TimelineRecord? {
    val selectStatement = select(columnList){
        from(thinkinglogTable)
        leftJoin(taskTable) {
            on(Thinkinglog.taskid,) equalTo(Task.taskid)
        }
        leftJoin(userTable) {
            on(Thinkinglog.userid) equalTo(User.userid)
        }
        where{ Thinkinglog.logid isEqualTo id }
    }
    return selectOne(selectStatement)
}