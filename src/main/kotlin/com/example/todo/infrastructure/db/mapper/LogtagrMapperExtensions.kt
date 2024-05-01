/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.Logtagr
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.Logtagr.logid
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.Logtagr.logtagid
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.Logtagr.logtagrid
import com.example.todo.infrastructure.db.record.LogtagrRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun LogtagrMapper.count(completer: CountCompleter) =
    countFrom(this::count, Logtagr, completer)

fun LogtagrMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Logtagr, completer)

fun LogtagrMapper.deleteByPrimaryKey(logtagrid_: Int) =
    delete {
        where(logtagrid, isEqualTo(logtagrid_))
    }

fun LogtagrMapper.insert(record: LogtagrRecord) =
    insert(this::insert, record, Logtagr) {
        map(logtagrid).toProperty("logtagrid")
        map(logid).toProperty("logid")
        map(logtagid).toProperty("logtagid")
    }

fun LogtagrMapper.insertMultiple(records: Collection<LogtagrRecord>) =
    insertMultiple(this::insertMultiple, records, Logtagr) {
        map(logtagrid).toProperty("logtagrid")
        map(logid).toProperty("logid")
        map(logtagid).toProperty("logtagid")
    }

fun LogtagrMapper.insertMultiple(vararg records: LogtagrRecord) =
    insertMultiple(records.toList())

fun LogtagrMapper.insertSelective(record: LogtagrRecord) =
    insert(this::insert, record, Logtagr) {
        map(logtagrid).toPropertyWhenPresent("logtagrid", record::logtagrid)
        map(logid).toPropertyWhenPresent("logid", record::logid)
        map(logtagid).toPropertyWhenPresent("logtagid", record::logtagid)
    }

private val columnList = listOf(logtagrid, logid, logtagid)

fun LogtagrMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Logtagr, completer)

fun LogtagrMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Logtagr, completer)

fun LogtagrMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Logtagr, completer)

fun LogtagrMapper.selectByPrimaryKey(logtagrid_: Int) =
    selectOne {
        where(logtagrid, isEqualTo(logtagrid_))
    }

fun LogtagrMapper.update(completer: UpdateCompleter) =
    update(this::update, Logtagr, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: LogtagrRecord) =
    apply {
        set(logtagrid).equalTo(record::logtagrid)
        set(logid).equalTo(record::logid)
        set(logtagid).equalTo(record::logtagid)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: LogtagrRecord) =
    apply {
        set(logtagrid).equalToWhenPresent(record::logtagrid)
        set(logid).equalToWhenPresent(record::logid)
        set(logtagid).equalToWhenPresent(record::logtagid)
    }

fun LogtagrMapper.updateByPrimaryKey(record: LogtagrRecord) =
    update {
        set(logid).equalTo(record::logid)
        set(logtagid).equalTo(record::logtagid)
        where(logtagrid, isEqualTo(record::logtagrid))
    }

fun LogtagrMapper.updateByPrimaryKeySelective(record: LogtagrRecord) =
    update {
        set(logid).equalToWhenPresent(record::logid)
        set(logtagid).equalToWhenPresent(record::logtagid)
        where(logtagrid, isEqualTo(record::logtagrid))
    }