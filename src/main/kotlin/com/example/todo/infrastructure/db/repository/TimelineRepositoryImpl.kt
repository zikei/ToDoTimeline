package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.model.Timeline
import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.infrastructure.db.mapper.custom.TimelineMapper
import com.example.todo.infrastructure.db.mapper.custom.selectByUserId
import com.example.todo.infrastructure.db.record.custom.TimelineRecord
import org.springframework.stereotype.Repository

@Repository
class TimelineRepositoryImpl(
    private val tlMapper: TimelineMapper
) : TimelineRepository {
    override fun findListByUserId(userId: Int): List<Timeline> {
        return tlMapper.selectByUserId(userId).map { toModel(it) }
    }

    /** TodoレコードをTodoモデルに変換 */
    private fun toModel(record: TimelineRecord): Timeline {
        return Timeline(
            record.logid!!,
            record.taskid,
            record.userid!!,
            record.createdate!!,
            record.contents!!,
            record.taskname,
            record.dspname!!
        )
    }
}