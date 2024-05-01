/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.News
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.News.contents
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.News.createdate
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.News.newsid
import com.example.todo.infrastructure.db.record.NewsRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun NewsMapper.count(completer: CountCompleter) =
    countFrom(this::count, News, completer)

fun NewsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, News, completer)

fun NewsMapper.deleteByPrimaryKey(newsid_: Int) =
    delete {
        where(newsid, isEqualTo(newsid_))
    }

fun NewsMapper.insert(record: NewsRecord) =
    insert(this::insert, record, News) {
        map(newsid).toProperty("newsid")
        map(contents).toProperty("contents")
        map(createdate).toProperty("createdate")
    }

fun NewsMapper.insertMultiple(records: Collection<NewsRecord>) =
    insertMultiple(this::insertMultiple, records, News) {
        map(newsid).toProperty("newsid")
        map(contents).toProperty("contents")
        map(createdate).toProperty("createdate")
    }

fun NewsMapper.insertMultiple(vararg records: NewsRecord) =
    insertMultiple(records.toList())

fun NewsMapper.insertSelective(record: NewsRecord) =
    insert(this::insert, record, News) {
        map(newsid).toPropertyWhenPresent("newsid", record::newsid)
        map(contents).toPropertyWhenPresent("contents", record::contents)
        map(createdate).toPropertyWhenPresent("createdate", record::createdate)
    }

private val columnList = listOf(newsid, contents, createdate)

fun NewsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, News, completer)

fun NewsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, News, completer)

fun NewsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, News, completer)

fun NewsMapper.selectByPrimaryKey(newsid_: Int) =
    selectOne {
        where(newsid, isEqualTo(newsid_))
    }

fun NewsMapper.update(completer: UpdateCompleter) =
    update(this::update, News, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: NewsRecord) =
    apply {
        set(newsid).equalTo(record::newsid)
        set(contents).equalTo(record::contents)
        set(createdate).equalTo(record::createdate)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: NewsRecord) =
    apply {
        set(newsid).equalToWhenPresent(record::newsid)
        set(contents).equalToWhenPresent(record::contents)
        set(createdate).equalToWhenPresent(record::createdate)
    }

fun NewsMapper.updateByPrimaryKey(record: NewsRecord) =
    update {
        set(contents).equalTo(record::contents)
        set(createdate).equalTo(record::createdate)
        where(newsid, isEqualTo(record::newsid))
    }

fun NewsMapper.updateByPrimaryKeySelective(record: NewsRecord) =
    update {
        set(contents).equalToWhenPresent(record::contents)
        set(createdate).equalToWhenPresent(record::createdate)
        where(newsid, isEqualTo(record::newsid))
    }