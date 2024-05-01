/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.Tasktagr
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.Tasktagr.taskid
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.Tasktagr.tasktagid
import com.example.todo.infrastructure.db.mapper.TasktagrDynamicSqlSupport.Tasktagr.tasktagrid
import com.example.todo.infrastructure.db.record.TasktagrRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TasktagrMapper.count(completer: CountCompleter) =
    countFrom(this::count, Tasktagr, completer)

fun TasktagrMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Tasktagr, completer)

fun TasktagrMapper.deleteByPrimaryKey(tasktagrid_: Int) =
    delete {
        where(tasktagrid, isEqualTo(tasktagrid_))
    }

fun TasktagrMapper.insert(record: TasktagrRecord) =
    insert(this::insert, record, Tasktagr) {
        map(tasktagrid).toProperty("tasktagrid")
        map(taskid).toProperty("taskid")
        map(tasktagid).toProperty("tasktagid")
    }

fun TasktagrMapper.insertMultiple(records: Collection<TasktagrRecord>) =
    insertMultiple(this::insertMultiple, records, Tasktagr) {
        map(tasktagrid).toProperty("tasktagrid")
        map(taskid).toProperty("taskid")
        map(tasktagid).toProperty("tasktagid")
    }

fun TasktagrMapper.insertMultiple(vararg records: TasktagrRecord) =
    insertMultiple(records.toList())

fun TasktagrMapper.insertSelective(record: TasktagrRecord) =
    insert(this::insert, record, Tasktagr) {
        map(tasktagrid).toPropertyWhenPresent("tasktagrid", record::tasktagrid)
        map(taskid).toPropertyWhenPresent("taskid", record::taskid)
        map(tasktagid).toPropertyWhenPresent("tasktagid", record::tasktagid)
    }

private val columnList = listOf(tasktagrid, taskid, tasktagid)

fun TasktagrMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Tasktagr, completer)

fun TasktagrMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Tasktagr, completer)

fun TasktagrMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Tasktagr, completer)

fun TasktagrMapper.selectByPrimaryKey(tasktagrid_: Int) =
    selectOne {
        where(tasktagrid, isEqualTo(tasktagrid_))
    }

fun TasktagrMapper.update(completer: UpdateCompleter) =
    update(this::update, Tasktagr, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TasktagrRecord) =
    apply {
        set(tasktagrid).equalTo(record::tasktagrid)
        set(taskid).equalTo(record::taskid)
        set(tasktagid).equalTo(record::tasktagid)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TasktagrRecord) =
    apply {
        set(tasktagrid).equalToWhenPresent(record::tasktagrid)
        set(taskid).equalToWhenPresent(record::taskid)
        set(tasktagid).equalToWhenPresent(record::tasktagid)
    }

fun TasktagrMapper.updateByPrimaryKey(record: TasktagrRecord) =
    update {
        set(taskid).equalTo(record::taskid)
        set(tasktagid).equalTo(record::tasktagid)
        where(tasktagrid, isEqualTo(record::tasktagrid))
    }

fun TasktagrMapper.updateByPrimaryKeySelective(record: TasktagrRecord) =
    update {
        set(taskid).equalToWhenPresent(record::taskid)
        set(tasktagid).equalToWhenPresent(record::tasktagid)
        where(tasktagrid, isEqualTo(record::tasktagrid))
    }