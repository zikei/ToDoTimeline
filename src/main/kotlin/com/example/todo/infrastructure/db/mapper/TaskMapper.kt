/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.record.TaskRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface TaskMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    fun insert(insertStatement: InsertStatementProvider<TaskRecord>): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insertMultiple")
    fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<TaskRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("TaskRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): TaskRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="TaskRecordResult", value = [
        Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
        Result(column="createDate", property="createdate", jdbcType=JdbcType.DATE),
        Result(column="severity", property="severity", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
        Result(column="deadline", property="deadline", jdbcType=JdbcType.DATE),
        Result(column="taskStatus", property="taskstatus", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
        Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<TaskRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}