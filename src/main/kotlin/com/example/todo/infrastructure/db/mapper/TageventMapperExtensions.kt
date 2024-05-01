/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.Tagevent
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.Tagevent.eventname
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.Tagevent.eventoutline
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.Tagevent.tageventid
import com.example.todo.infrastructure.db.record.TageventRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TageventMapper.count(completer: CountCompleter) =
    countFrom(this::count, Tagevent, completer)

fun TageventMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Tagevent, completer)

fun TageventMapper.deleteByPrimaryKey(tageventid_: Int) =
    delete {
        where(tageventid, isEqualTo(tageventid_))
    }

fun TageventMapper.insert(record: TageventRecord) =
    insert(this::insert, record, Tagevent) {
        map(tageventid).toProperty("tageventid")
        map(eventname).toProperty("eventname")
        map(eventoutline).toProperty("eventoutline")
    }

fun TageventMapper.insertMultiple(records: Collection<TageventRecord>) =
    insertMultiple(this::insertMultiple, records, Tagevent) {
        map(tageventid).toProperty("tageventid")
        map(eventname).toProperty("eventname")
        map(eventoutline).toProperty("eventoutline")
    }

fun TageventMapper.insertMultiple(vararg records: TageventRecord) =
    insertMultiple(records.toList())

fun TageventMapper.insertSelective(record: TageventRecord) =
    insert(this::insert, record, Tagevent) {
        map(tageventid).toPropertyWhenPresent("tageventid", record::tageventid)
        map(eventname).toPropertyWhenPresent("eventname", record::eventname)
        map(eventoutline).toPropertyWhenPresent("eventoutline", record::eventoutline)
    }

private val columnList = listOf(tageventid, eventname, eventoutline)

fun TageventMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Tagevent, completer)

fun TageventMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Tagevent, completer)

fun TageventMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Tagevent, completer)

fun TageventMapper.selectByPrimaryKey(tageventid_: Int) =
    selectOne {
        where(tageventid, isEqualTo(tageventid_))
    }

fun TageventMapper.update(completer: UpdateCompleter) =
    update(this::update, Tagevent, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TageventRecord) =
    apply {
        set(tageventid).equalTo(record::tageventid)
        set(eventname).equalTo(record::eventname)
        set(eventoutline).equalTo(record::eventoutline)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TageventRecord) =
    apply {
        set(tageventid).equalToWhenPresent(record::tageventid)
        set(eventname).equalToWhenPresent(record::eventname)
        set(eventoutline).equalToWhenPresent(record::eventoutline)
    }

fun TageventMapper.updateByPrimaryKey(record: TageventRecord) =
    update {
        set(eventname).equalTo(record::eventname)
        set(eventoutline).equalTo(record::eventoutline)
        where(tageventid, isEqualTo(record::tageventid))
    }

fun TageventMapper.updateByPrimaryKeySelective(record: TageventRecord) =
    update {
        set(eventname).equalToWhenPresent(record::eventname)
        set(eventoutline).equalToWhenPresent(record::eventoutline)
        where(tageventid, isEqualTo(record::tageventid))
    }