package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.model.User
import com.example.todo.domain.repository.UserRepository
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport
import com.example.todo.infrastructure.db.mapper.UserMapper
import com.example.todo.infrastructure.db.mapper.selectByPrimaryKey
import com.example.todo.infrastructure.db.mapper.selectOne
import com.example.todo.infrastructure.db.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UserMapper
) : UserRepository{

    override fun findById(id: Int): User? {
        val record = mapper.selectByPrimaryKey(id)
        return record?.let { toModel(it) }
    }

    override fun findByUserName(name: String): User? {
        val record = mapper.selectOne{
            where(UserDynamicSqlSupport.User.username, isEqualTo(name))
        }
        return record?.let { toModel(it) }
    }

    private fun toModel(record: UserRecord): User {
        return User(
            record.userid!!,
            record.username!!,
            record.dspname!!,
            record.password!!,
            record.role!!
        )
    }
}