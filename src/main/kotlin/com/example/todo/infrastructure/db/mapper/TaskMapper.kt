/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.createdate
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.deadline
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.memo
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.parentid
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.severity
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.task
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.taskid
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.taskname
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.taskstatus
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.record.Task
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.EnumTypeHandler
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
interface TaskMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Task>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="TaskResult", value = [
        Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        Result(column="taskName", property="taskname", jdbcType=JdbcType.VARCHAR),
        Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        Result(column="createDate", property="createdate", jdbcType=JdbcType.DATE),
        Result(column="severity", property="severity", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
        Result(column="deadline", property="deadline", jdbcType=JdbcType.DATE),
        Result(column="taskStatus", property="taskstatus", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR),
        Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Task>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("TaskResult")
    fun selectOne(selectStatement: SelectStatementProvider): Task?
}

fun TaskMapper.count(completer: CountCompleter) =
    countFrom(this::count, task, completer)

fun TaskMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, task, completer)

fun TaskMapper.deleteByPrimaryKey(taskid_: Int) =
    delete {
        where { taskid isEqualTo taskid_ }
    }

fun TaskMapper.insert(row: Task) =
    insert(this::insert, row, task) {
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(taskname) toProperty "taskname"
        map(memo) toProperty "memo"
        map(createdate) toProperty "createdate"
        map(severity) toProperty "severity"
        map(deadline) toProperty "deadline"
        map(taskstatus) toProperty "taskstatus"
        map(parentid) toProperty "parentid"
    }

fun TaskMapper.insertMultiple(records: Collection<Task>) =
    insertMultiple(this::insertMultiple, records, task) {
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(taskname) toProperty "taskname"
        map(memo) toProperty "memo"
        map(createdate) toProperty "createdate"
        map(severity) toProperty "severity"
        map(deadline) toProperty "deadline"
        map(taskstatus) toProperty "taskstatus"
        map(parentid) toProperty "parentid"
    }

fun TaskMapper.insertMultiple(vararg records: Task) =
    insertMultiple(records.toList())

fun TaskMapper.insertSelective(row: Task) =
    insert(this::insert, row, task) {
        map(taskid).toPropertyWhenPresent("taskid", row::taskid)
        map(userid).toPropertyWhenPresent("userid", row::userid)
        map(taskname).toPropertyWhenPresent("taskname", row::taskname)
        map(memo).toPropertyWhenPresent("memo", row::memo)
        map(createdate).toPropertyWhenPresent("createdate", row::createdate)
        map(severity).toPropertyWhenPresent("severity", row::severity)
        map(deadline).toPropertyWhenPresent("deadline", row::deadline)
        map(taskstatus).toPropertyWhenPresent("taskstatus", row::taskstatus)
        map(parentid).toPropertyWhenPresent("parentid", row::parentid)
    }

private val columnList = listOf(taskid, userid, taskname, memo, createdate, severity, deadline, taskstatus, parentid)

fun TaskMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, task, completer)

fun TaskMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, task, completer)

fun TaskMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, task, completer)

fun TaskMapper.selectByPrimaryKey(taskid_: Int) =
    selectOne {
        where { taskid isEqualTo taskid_ }
    }

fun TaskMapper.update(completer: UpdateCompleter) =
    update(this::update, task, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Task) =
    apply {
        set(taskid) equalToOrNull row::taskid
        set(userid) equalToOrNull row::userid
        set(taskname) equalToOrNull row::taskname
        set(memo) equalToOrNull row::memo
        set(createdate) equalToOrNull row::createdate
        set(severity) equalToOrNull row::severity
        set(deadline) equalToOrNull row::deadline
        set(taskstatus) equalToOrNull row::taskstatus
        set(parentid) equalToOrNull row::parentid
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Task) =
    apply {
        set(taskid) equalToWhenPresent row::taskid
        set(userid) equalToWhenPresent row::userid
        set(taskname) equalToWhenPresent row::taskname
        set(memo) equalToWhenPresent row::memo
        set(createdate) equalToWhenPresent row::createdate
        set(severity) equalToWhenPresent row::severity
        set(deadline) equalToWhenPresent row::deadline
        set(taskstatus) equalToWhenPresent row::taskstatus
        set(parentid) equalToWhenPresent row::parentid
    }

fun TaskMapper.updateByPrimaryKey(row: Task) =
    update {
        set(userid) equalToOrNull row::userid
        set(taskname) equalToOrNull row::taskname
        set(memo) equalToOrNull row::memo
        set(createdate) equalToOrNull row::createdate
        set(severity) equalToOrNull row::severity
        set(deadline) equalToOrNull row::deadline
        set(taskstatus) equalToOrNull row::taskstatus
        set(parentid) equalToOrNull row::parentid
        where { taskid isEqualTo row.taskid!! }
    }

fun TaskMapper.updateByPrimaryKeySelective(row: Task) =
    update {
        set(userid) equalToWhenPresent row::userid
        set(taskname) equalToWhenPresent row::taskname
        set(memo) equalToWhenPresent row::memo
        set(createdate) equalToWhenPresent row::createdate
        set(severity) equalToWhenPresent row::severity
        set(deadline) equalToWhenPresent row::deadline
        set(taskstatus) equalToWhenPresent row::taskstatus
        set(parentid) equalToWhenPresent row::parentid
        where { taskid isEqualTo row.taskid!! }
    }