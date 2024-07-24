/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType
import java.time.LocalDateTime

object NewsDynamicSqlSupport {
    val news = News()

    val newsid = news.newsid

    val contents = news.contents

    val createdate = news.createdate

    class News : AliasableSqlTable<News>("news", ::News) {
        val newsid = column<Int>(name = "newsId", jdbcType = JDBCType.INTEGER)

        val contents = column<String>(name = "contents", jdbcType = JDBCType.VARCHAR)

        val createdate = column<LocalDateTime>(name = "createDate", jdbcType = JDBCType.TIMESTAMP)
    }
}