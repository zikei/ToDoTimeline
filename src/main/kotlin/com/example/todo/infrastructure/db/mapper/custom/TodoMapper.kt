package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport as Task
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.task as taskTable
import com.example.todo.infrastructure.db.mapper.custom.ParentTaskDynamicSqlSupport as PTask
import com.example.todo.infrastructure.db.mapper.custom.ParentTaskDynamicSqlSupport.ptask as ptaskTable

@Mapper
interface TodoMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "TodoRecordResult", value = [
            Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
            Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
            Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
            Result(column="createDate", property="createdate", jdbcType=JdbcType.DATE),
            Result(column="severity", property="severity", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
            Result(column="deadline", property="deadline", jdbcType=JdbcType.DATE),
            Result(column="taskStatus", property="taskstatus", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),

            Result(column="ptaskId", property="ptaskid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="puserId", property="puserid", jdbcType=JdbcType.INTEGER),
            Result(column="ptaskName", property="ptaskname", jdbcType=JdbcType.VARCHAR),
            Result(column="pmemo", property="pmemo", jdbcType=JdbcType.VARCHAR),
            Result(column="pcreateDate", property="pcreatedate", jdbcType=JdbcType.DATE),
            Result(column="pseverity", property="pseverity", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
            Result(column="pdeadline", property="pdeadline", jdbcType=JdbcType.DATE),
            Result(column="ptaskStatus", property="ptaskstatus", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider) : List<TodoRecord>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("TodoRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider) : TodoRecord?
}

private val columnList = listOf(
    Task.taskid,
    Task.userid,
    Task.taskname,
    Task.memo,
    Task.createdate,
    Task.severity,
    Task.deadline,
    Task.taskstatus,

    PTask.ptaskid,
    PTask.puserid,
    PTask.ptaskname,
    PTask.pmemo,
    PTask.pcreatedate,
    PTask.pseverity,
    PTask.pdeadline,
    PTask.ptaskstatus

)

fun TodoMapper.select(): List<TodoRecord> {
    val selectStatement = select(columnList){
        from(taskTable)
        leftJoin(ptaskTable, "ptask") {
            on(Task.parentid) equalTo(PTask.ptaskid)
        }
    }
    return selectMany(selectStatement)
}

fun TodoMapper.selectByUserId(id : Int): List<TodoRecord>{
    val selectStatement = select(columnList){
        from(taskTable)
        leftJoin(ptaskTable, "ptask") {
            on(Task.parentid) equalTo(PTask.ptaskid)
        }
        where { Task.userid isEqualTo id }
    }
    return selectMany(selectStatement)
}

fun TodoMapper.selectByPrimaryKey(id: Int): TodoRecord? {
    val selectStatement = select(columnList){
        from(taskTable)
        leftJoin(ptaskTable, "ptask") {
            on(Task.parentid) equalTo(PTask.ptaskid)
        }
        where { Task.taskid isEqualTo id }
    }
    return selectOne(selectStatement)
}