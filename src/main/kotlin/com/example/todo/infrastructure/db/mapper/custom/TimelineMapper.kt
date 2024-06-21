package com.example.todo.infrastructure.db.mapper.custom

import com.example.todo.infrastructure.db.record.custom.TimelineRecord
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface TimelineMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "TimelineRecordResult", value = [
            Result(column="logId", property="logid", jdbcType=JdbcType.INTEGER, id=true),
            Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER),
            Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
            Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
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