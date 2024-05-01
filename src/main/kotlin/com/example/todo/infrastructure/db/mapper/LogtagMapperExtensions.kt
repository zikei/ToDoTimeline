/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.Logtag
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.Logtag.logtagid
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.Logtag.tageventid
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.Logtag.tagname
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.Logtag.userid
import com.example.todo.infrastructure.db.record.LogtagRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun LogtagMapper.count(completer: CountCompleter) =
    countFrom(this::count, Logtag, completer)

fun LogtagMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Logtag, completer)

fun LogtagMapper.deleteByPrimaryKey(logtagid_: Int) =
    delete {
        where(logtagid, isEqualTo(logtagid_))
    }

fun LogtagMapper.insert(record: LogtagRecord) =
    insert(this::insert, record, Logtag) {
        map(logtagid).toProperty("logtagid")
        map(tagname).toProperty("tagname")
        map(userid).toProperty("userid")
        map(tageventid).toProperty("tageventid")
    }

fun LogtagMapper.insertMultiple(records: Collection<LogtagRecord>) =
    insertMultiple(this::insertMultiple, records, Logtag) {
        map(logtagid).toProperty("logtagid")
        map(tagname).toProperty("tagname")
        map(userid).toProperty("userid")
        map(tageventid).toProperty("tageventid")
    }

fun LogtagMapper.insertMultiple(vararg records: LogtagRecord) =
    insertMultiple(records.toList())

fun LogtagMapper.insertSelective(record: LogtagRecord) =
    insert(this::insert, record, Logtag) {
        map(logtagid).toPropertyWhenPresent("logtagid", record::logtagid)
        map(tagname).toPropertyWhenPresent("tagname", record::tagname)
        map(userid).toPropertyWhenPresent("userid", record::userid)
        map(tageventid).toPropertyWhenPresent("tageventid", record::tageventid)
    }

private val columnList = listOf(logtagid, tagname, userid, tageventid)

fun LogtagMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Logtag, completer)

fun LogtagMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Logtag, completer)

fun LogtagMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Logtag, completer)

fun LogtagMapper.selectByPrimaryKey(logtagid_: Int) =
    selectOne {
        where(logtagid, isEqualTo(logtagid_))
    }

fun LogtagMapper.update(completer: UpdateCompleter) =
    update(this::update, Logtag, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: LogtagRecord) =
    apply {
        set(logtagid).equalTo(record::logtagid)
        set(tagname).equalTo(record::tagname)
        set(userid).equalTo(record::userid)
        set(tageventid).equalTo(record::tageventid)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: LogtagRecord) =
    apply {
        set(logtagid).equalToWhenPresent(record::logtagid)
        set(tagname).equalToWhenPresent(record::tagname)
        set(userid).equalToWhenPresent(record::userid)
        set(tageventid).equalToWhenPresent(record::tageventid)
    }

fun LogtagMapper.updateByPrimaryKey(record: LogtagRecord) =
    update {
        set(tagname).equalTo(record::tagname)
        set(userid).equalTo(record::userid)
        set(tageventid).equalTo(record::tageventid)
        where(logtagid, isEqualTo(record::logtagid))
    }

fun LogtagMapper.updateByPrimaryKeySelective(record: LogtagRecord) =
    update {
        set(tagname).equalToWhenPresent(record::tagname)
        set(userid).equalToWhenPresent(record::userid)
        set(tageventid).equalToWhenPresent(record::tageventid)
        where(logtagid, isEqualTo(record::logtagid))
    }