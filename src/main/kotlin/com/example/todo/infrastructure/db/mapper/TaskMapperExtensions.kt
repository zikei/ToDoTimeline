/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.createdate
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.deadline
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.memo
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.parentid
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.severity
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.taskid
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.taskname
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.taskstatus
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task.userid
import com.example.todo.infrastructure.db.record.TaskRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TaskMapper.count(completer: CountCompleter) =
    countFrom(this::count, Task, completer)

fun TaskMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Task, completer)

fun TaskMapper.deleteByPrimaryKey(taskid_: Int) =
    delete {
        where(taskid, isEqualTo(taskid_))
    }

fun TaskMapper.insert(record: TaskRecord) =
    insert(this::insert, record, Task) {
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(taskname).toProperty("taskname")
        map(memo).toProperty("memo")
        map(createdate).toProperty("createdate")
        map(severity).toProperty("severity")
        map(deadline).toProperty("deadline")
        map(taskstatus).toProperty("taskstatus")
        map(parentid).toProperty("parentid")
    }

fun TaskMapper.insertMultiple(records: Collection<TaskRecord>) =
    insertMultiple(this::insertMultiple, records, Task) {
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(taskname).toProperty("taskname")
        map(memo).toProperty("memo")
        map(createdate).toProperty("createdate")
        map(severity).toProperty("severity")
        map(deadline).toProperty("deadline")
        map(taskstatus).toProperty("taskstatus")
        map(parentid).toProperty("parentid")
    }

fun TaskMapper.insertMultiple(vararg records: TaskRecord) =
    insertMultiple(records.toList())

fun TaskMapper.insertSelective(record: TaskRecord) =
    insert(this::insert, record, Task) {
        map(taskid).toPropertyWhenPresent("taskid", record::taskid)
        map(userid).toPropertyWhenPresent("userid", record::userid)
        map(taskname).toPropertyWhenPresent("taskname", record::taskname)
        map(memo).toPropertyWhenPresent("memo", record::memo)
        map(createdate).toPropertyWhenPresent("createdate", record::createdate)
        map(severity).toPropertyWhenPresent("severity", record::severity)
        map(deadline).toPropertyWhenPresent("deadline", record::deadline)
        map(taskstatus).toPropertyWhenPresent("taskstatus", record::taskstatus)
        map(parentid).toPropertyWhenPresent("parentid", record::parentid)
    }

private val columnList = listOf(taskid, userid, taskname, memo, createdate, severity, deadline, taskstatus, parentid)

fun TaskMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Task, completer)

fun TaskMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Task, completer)

fun TaskMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Task, completer)

fun TaskMapper.selectByPrimaryKey(taskid_: Int) =
    selectOne {
        where(taskid, isEqualTo(taskid_))
    }

fun TaskMapper.update(completer: UpdateCompleter) =
    update(this::update, Task, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TaskRecord) =
    apply {
        set(taskid).equalTo(record::taskid)
        set(userid).equalTo(record::userid)
        set(taskname).equalTo(record::taskname)
        set(memo).equalTo(record::memo)
        set(createdate).equalTo(record::createdate)
        set(severity).equalTo(record::severity)
        set(deadline).equalTo(record::deadline)
        set(taskstatus).equalTo(record::taskstatus)
        set(parentid).equalTo(record::parentid)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TaskRecord) =
    apply {
        set(taskid).equalToWhenPresent(record::taskid)
        set(userid).equalToWhenPresent(record::userid)
        set(taskname).equalToWhenPresent(record::taskname)
        set(memo).equalToWhenPresent(record::memo)
        set(createdate).equalToWhenPresent(record::createdate)
        set(severity).equalToWhenPresent(record::severity)
        set(deadline).equalToWhenPresent(record::deadline)
        set(taskstatus).equalToWhenPresent(record::taskstatus)
        set(parentid).equalToWhenPresent(record::parentid)
    }

fun TaskMapper.updateByPrimaryKey(record: TaskRecord) =
    update {
        set(userid).equalTo(record::userid)
        set(taskname).equalTo(record::taskname)
        set(memo).equalTo(record::memo)
        set(createdate).equalTo(record::createdate)
        set(severity).equalTo(record::severity)
        set(deadline).equalTo(record::deadline)
        set(taskstatus).equalTo(record::taskstatus)
        set(parentid).equalTo(record::parentid)
        where(taskid, isEqualTo(record::taskid))
    }

fun TaskMapper.updateByPrimaryKeySelective(record: TaskRecord) =
    update {
        set(userid).equalToWhenPresent(record::userid)
        set(taskname).equalToWhenPresent(record::taskname)
        set(memo).equalToWhenPresent(record::memo)
        set(createdate).equalToWhenPresent(record::createdate)
        set(severity).equalToWhenPresent(record::severity)
        set(deadline).equalToWhenPresent(record::deadline)
        set(taskstatus).equalToWhenPresent(record::taskstatus)
        set(parentid).equalToWhenPresent(record::parentid)
        where(taskid, isEqualTo(record::taskid))
    }