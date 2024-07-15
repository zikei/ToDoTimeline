package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline
import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.infrastructure.db.mapper.ThinkinglogMapper
import com.example.todo.infrastructure.db.mapper.custom.TimelineMapper
import com.example.todo.infrastructure.db.mapper.custom.selectByPrimaryKey
import com.example.todo.infrastructure.db.mapper.custom.selectByTaskId
import com.example.todo.infrastructure.db.mapper.custom.selectByUserId
import com.example.todo.infrastructure.db.mapper.insert
import com.example.todo.infrastructure.db.record.ThinkinglogRecord
import com.example.todo.infrastructure.db.record.custom.TimelineRecord
import org.springframework.stereotype.Repository

@Repository
class TimelineRepositoryImpl(
    private val tlMapper: TimelineMapper,
    private val thlogMapper: ThinkinglogMapper

) : TimelineRepository {
    override fun findListByUserId(userId: Int): List<Timeline> {
        return tlMapper.selectByUserId(userId).map { toModel(it) }
    }

    override fun findListByTaskId(taskId: Int): List<Timeline> {
        return tlMapper.selectByTaskId(taskId).map { toModel(it) }
    }

    override fun findById(logId: Int): Timeline? {
        return tlMapper.selectByPrimaryKey(logId)?.let { toModel(it) }
    }

    override fun insertPost(post: Thinkinglog): Int {
        val thlogRecord = toRecord(post)
        thlogMapper.insert(thlogRecord)
        return thlogRecord.logid!!
    }

    /** TodoレコードをTodoモデルに変換 */
    private fun toModel(record: TimelineRecord): Timeline {
        return Timeline(
            record.logid!!,
            record.taskid,
            record.userid!!,
            record.role!!,
            record.createdate!!,
            record.contents!!,
            record.taskname,
            record.dspname!!
        )
    }

    /** Thinkinglogモデルをレコードに変換 */
    private fun toRecord(model: Thinkinglog): ThinkinglogRecord{
        return ThinkinglogRecord(
            model.logid,
            model.taskid,
            model.userid,
            model.createdate,
            model.contents
        )
    }
}