/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.contents
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.createdate
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.news
import com.example.todo.infrastructure.db.mapper.NewsDynamicSqlSupport.newsid
import com.example.todo.infrastructure.db.record.News
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
interface NewsMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<News>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="NewsResult", value = [
        Result(column="newsId", property="newsid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR),
        Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<News>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("NewsResult")
    fun selectOne(selectStatement: SelectStatementProvider): News?
}

fun NewsMapper.count(completer: CountCompleter) =
    countFrom(this::count, news, completer)

fun NewsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, news, completer)

fun NewsMapper.deleteByPrimaryKey(newsid_: Int) =
    delete {
        where { newsid isEqualTo newsid_ }
    }

fun NewsMapper.insert(row: News) =
    insert(this::insert, row, news) {
        map(newsid) toProperty "newsid"
        map(contents) toProperty "contents"
        map(createdate) toProperty "createdate"
    }

fun NewsMapper.insertMultiple(records: Collection<News>) =
    insertMultiple(this::insertMultiple, records, news) {
        map(newsid) toProperty "newsid"
        map(contents) toProperty "contents"
        map(createdate) toProperty "createdate"
    }

fun NewsMapper.insertMultiple(vararg records: News) =
    insertMultiple(records.toList())

fun NewsMapper.insertSelective(row: News) =
    insert(this::insert, row, news) {
        map(newsid).toPropertyWhenPresent("newsid", row::newsid)
        map(contents).toPropertyWhenPresent("contents", row::contents)
        map(createdate).toPropertyWhenPresent("createdate", row::createdate)
    }

private val columnList = listOf(newsid, contents, createdate)

fun NewsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, news, completer)

fun NewsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, news, completer)

fun NewsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, news, completer)

fun NewsMapper.selectByPrimaryKey(newsid_: Int) =
    selectOne {
        where { newsid isEqualTo newsid_ }
    }

fun NewsMapper.update(completer: UpdateCompleter) =
    update(this::update, news, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: News) =
    apply {
        set(newsid) equalToOrNull row::newsid
        set(contents) equalToOrNull row::contents
        set(createdate) equalToOrNull row::createdate
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: News) =
    apply {
        set(newsid) equalToWhenPresent row::newsid
        set(contents) equalToWhenPresent row::contents
        set(createdate) equalToWhenPresent row::createdate
    }

fun NewsMapper.updateByPrimaryKey(row: News) =
    update {
        set(contents) equalToOrNull row::contents
        set(createdate) equalToOrNull row::createdate
        where { newsid isEqualTo row.newsid!! }
    }

fun NewsMapper.updateByPrimaryKeySelective(row: News) =
    update {
        set(contents) equalToWhenPresent row::contents
        set(createdate) equalToWhenPresent row::createdate
        where { newsid isEqualTo row.newsid!! }
    }