package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface TodoMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "TodoRecordResult", value = [
            Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
            Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
            Result(column="createDate", property="createdate", jdbcType=JdbcType.DATE),
            Result(column="severity", property="severity", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
            Result(column="deadline", property="deadline", jdbcType=JdbcType.DATE),
            Result(column="taskStatus", property="taskstatus", typeHandler= EnumTypeHandler::class, jdbcType=JdbcType.CHAR),

            Result(column="ptaskId", property="ptaskid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="puserId", property="puserid", jdbcType=JdbcType.INTEGER),
            Result(column="ptaskName", property="ptaskname", jdbcType=JdbcType.VARCHAR),
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