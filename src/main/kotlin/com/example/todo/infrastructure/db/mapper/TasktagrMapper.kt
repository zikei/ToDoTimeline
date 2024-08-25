/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.taskid
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.tasktagid
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.tasktagr
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.tasktagrid
import com.example.todo.infrastructure.db.record.Tasktagr
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface TasktagrMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Tasktagr>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="TasktagrResult", value = [
        Result(column="tasktagRId", property="tasktagrid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER),
        Result(column="tasktagId", property="tasktagid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Tasktagr>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("TasktagrResult")
    fun selectOne(selectStatement: SelectStatementProvider): Tasktagr?
}

fun TasktagrMapper.count(completer: CountCompleter) =
    countFrom(this::count, tasktagr, completer)

fun TasktagrMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, tasktagr, completer)

fun TasktagrMapper.deleteByPrimaryKey(tasktagrid_: Int) =
    delete {
        where { tasktagrid isEqualTo tasktagrid_ }
    }

fun TasktagrMapper.insert(row: Tasktagr) =
    insert(this::insert, row, tasktagr) {
        map(tasktagrid) toProperty "tasktagrid"
        map(taskid) toProperty "taskid"
        map(tasktagid) toProperty "tasktagid"
    }

fun TasktagrMapper.insertMultiple(records: Collection<Tasktagr>) =
    insertMultiple(this::insertMultiple, records, tasktagr) {
        map(tasktagrid) toProperty "tasktagrid"
        map(taskid) toProperty "taskid"
        map(tasktagid) toProperty "tasktagid"
    }

fun TasktagrMapper.insertMultiple(vararg records: Tasktagr) =
    insertMultiple(records.toList())

fun TasktagrMapper.insertSelective(row: Tasktagr) =
    insert(this::insert, row, tasktagr) {
        map(tasktagrid).toPropertyWhenPresent("tasktagrid", row::tasktagrid)
        map(taskid).toPropertyWhenPresent("taskid", row::taskid)
        map(tasktagid).toPropertyWhenPresent("tasktagid", row::tasktagid)
    }

private val columnList = listOf(tasktagrid, taskid, tasktagid)

fun TasktagrMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, tasktagr, completer)

fun TasktagrMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, tasktagr, completer)

fun TasktagrMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, tasktagr, completer)

fun TasktagrMapper.selectByPrimaryKey(tasktagrid_: Int) =
    selectOne {
        where { tasktagrid isEqualTo tasktagrid_ }
    }

fun TasktagrMapper.update(completer: UpdateCompleter) =
    update(this::update, tasktagr, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Tasktagr) =
    apply {
        set(tasktagrid) equalToOrNull row::tasktagrid
        set(taskid) equalToOrNull row::taskid
        set(tasktagid) equalToOrNull row::tasktagid
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Tasktagr) =
    apply {
        set(tasktagrid) equalToWhenPresent row::tasktagrid
        set(taskid) equalToWhenPresent row::taskid
        set(tasktagid) equalToWhenPresent row::tasktagid
    }

fun TasktagrMapper.updateByPrimaryKey(row: Tasktagr) =
    update {
        set(taskid) equalToOrNull row::taskid
        set(tasktagid) equalToOrNull row::tasktagid
        where { tasktagrid isEqualTo row.tasktagrid!! }
    }

fun TasktagrMapper.updateByPrimaryKeySelective(row: Tasktagr) =
    update {
        set(taskid) equalToWhenPresent row::taskid
        set(tasktagid) equalToWhenPresent row::tasktagid
        where { tasktagrid isEqualTo row.tasktagrid!! }
    }