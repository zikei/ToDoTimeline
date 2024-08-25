/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.eventname
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.eventoutline
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.tagevent
import com.example.todo.infrastructure.db.mapper.TageventDynamicSqlSupport.tageventid
import com.example.todo.infrastructure.db.record.Tagevent
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
interface TageventMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Tagevent>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="TageventResult", value = [
        Result(column="tagEventId", property="tageventid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="eventName", property="eventname", jdbcType=JdbcType.VARCHAR),
        Result(column="eventOutline", property="eventoutline", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Tagevent>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("TageventResult")
    fun selectOne(selectStatement: SelectStatementProvider): Tagevent?
}

fun TageventMapper.count(completer: CountCompleter) =
    countFrom(this::count, tagevent, completer)

fun TageventMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, tagevent, completer)

fun TageventMapper.deleteByPrimaryKey(tageventid_: Int) =
    delete {
        where { tageventid isEqualTo tageventid_ }
    }

fun TageventMapper.insert(row: Tagevent) =
    insert(this::insert, row, tagevent) {
        map(tageventid) toProperty "tageventid"
        map(eventname) toProperty "eventname"
        map(eventoutline) toProperty "eventoutline"
    }

fun TageventMapper.insertMultiple(records: Collection<Tagevent>) =
    insertMultiple(this::insertMultiple, records, tagevent) {
        map(tageventid) toProperty "tageventid"
        map(eventname) toProperty "eventname"
        map(eventoutline) toProperty "eventoutline"
    }

fun TageventMapper.insertMultiple(vararg records: Tagevent) =
    insertMultiple(records.toList())

fun TageventMapper.insertSelective(row: Tagevent) =
    insert(this::insert, row, tagevent) {
        map(tageventid).toPropertyWhenPresent("tageventid", row::tageventid)
        map(eventname).toPropertyWhenPresent("eventname", row::eventname)
        map(eventoutline).toPropertyWhenPresent("eventoutline", row::eventoutline)
    }

private val columnList = listOf(tageventid, eventname, eventoutline)

fun TageventMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, tagevent, completer)

fun TageventMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, tagevent, completer)

fun TageventMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, tagevent, completer)

fun TageventMapper.selectByPrimaryKey(tageventid_: Int) =
    selectOne {
        where { tageventid isEqualTo tageventid_ }
    }

fun TageventMapper.update(completer: UpdateCompleter) =
    update(this::update, tagevent, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Tagevent) =
    apply {
        set(tageventid) equalToOrNull row::tageventid
        set(eventname) equalToOrNull row::eventname
        set(eventoutline) equalToOrNull row::eventoutline
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Tagevent) =
    apply {
        set(tageventid) equalToWhenPresent row::tageventid
        set(eventname) equalToWhenPresent row::eventname
        set(eventoutline) equalToWhenPresent row::eventoutline
    }

fun TageventMapper.updateByPrimaryKey(row: Tagevent) =
    update {
        set(eventname) equalToOrNull row::eventname
        set(eventoutline) equalToOrNull row::eventoutline
        where { tageventid isEqualTo row.tageventid!! }
    }

fun TageventMapper.updateByPrimaryKeySelective(row: Tagevent) =
    update {
        set(eventname) equalToWhenPresent row::eventname
        set(eventoutline) equalToWhenPresent row::eventoutline
        where { tageventid isEqualTo row.tageventid!! }
    }