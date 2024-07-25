/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.logtag
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.logtagid
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.tageventid
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.tagname
import com.example.todo.infrastructure.db.mapper.LogtagDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.record.Logtag
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
interface LogtagMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Logtag>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="LogtagResult", value = [
        Result(column="logtagId", property="logtagid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="tagName", property="tagname", jdbcType=JdbcType.VARCHAR),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        Result(column="tagEventId", property="tageventid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Logtag>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("LogtagResult")
    fun selectOne(selectStatement: SelectStatementProvider): Logtag?
}

fun LogtagMapper.count(completer: CountCompleter) =
    countFrom(this::count, logtag, completer)

fun LogtagMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, logtag, completer)

fun LogtagMapper.deleteByPrimaryKey(logtagid_: Int) =
    delete {
        where { logtagid isEqualTo logtagid_ }
    }

fun LogtagMapper.insert(row: Logtag) =
    insert(this::insert, row, logtag) {
        map(logtagid) toProperty "logtagid"
        map(tagname) toProperty "tagname"
        map(userid) toProperty "userid"
        map(tageventid) toProperty "tageventid"
    }

fun LogtagMapper.insertMultiple(records: Collection<Logtag>) =
    insertMultiple(this::insertMultiple, records, logtag) {
        map(logtagid) toProperty "logtagid"
        map(tagname) toProperty "tagname"
        map(userid) toProperty "userid"
        map(tageventid) toProperty "tageventid"
    }

fun LogtagMapper.insertMultiple(vararg records: Logtag) =
    insertMultiple(records.toList())

fun LogtagMapper.insertSelective(row: Logtag) =
    insert(this::insert, row, logtag) {
        map(logtagid).toPropertyWhenPresent("logtagid", row::logtagid)
        map(tagname).toPropertyWhenPresent("tagname", row::tagname)
        map(userid).toPropertyWhenPresent("userid", row::userid)
        map(tageventid).toPropertyWhenPresent("tageventid", row::tageventid)
    }

private val columnList = listOf(logtagid, tagname, userid, tageventid)

fun LogtagMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, logtag, completer)

fun LogtagMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, logtag, completer)

fun LogtagMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, logtag, completer)

fun LogtagMapper.selectByPrimaryKey(logtagid_: Int) =
    selectOne {
        where { logtagid isEqualTo logtagid_ }
    }

fun LogtagMapper.update(completer: UpdateCompleter) =
    update(this::update, logtag, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Logtag) =
    apply {
        set(logtagid) equalToOrNull row::logtagid
        set(tagname) equalToOrNull row::tagname
        set(userid) equalToOrNull row::userid
        set(tageventid) equalToOrNull row::tageventid
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Logtag) =
    apply {
        set(logtagid) equalToWhenPresent row::logtagid
        set(tagname) equalToWhenPresent row::tagname
        set(userid) equalToWhenPresent row::userid
        set(tageventid) equalToWhenPresent row::tageventid
    }

fun LogtagMapper.updateByPrimaryKey(row: Logtag) =
    update {
        set(tagname) equalToOrNull row::tagname
        set(userid) equalToOrNull row::userid
        set(tageventid) equalToOrNull row::tageventid
        where { logtagid isEqualTo row.logtagid!! }
    }

fun LogtagMapper.updateByPrimaryKeySelective(row: Logtag) =
    update {
        set(tagname) equalToWhenPresent row::tagname
        set(userid) equalToWhenPresent row::userid
        set(tageventid) equalToWhenPresent row::tageventid
        where { logtagid isEqualTo row.logtagid!! }
    }