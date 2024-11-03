package com.example.todo.app.service

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline
import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.domain.repository.UserRepository
import com.example.todo.domain.service.TimelineService
import com.example.todo.ui.form.GetTlListResponse
import com.example.todo.ui.form.TlInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class TimelineServiceImpl(
    @Autowired val tlRepo: TimelineRepository,
    @Autowired val userRepo: UserRepository,
    @Value("\${sse.timeout}") private val sseTimeout: String
) : TimelineService {
    private val timelineEmitters: MutableMap<EmitterMapKey, MutableList<SseEmitter>> = mutableMapOf()

    override fun getList(userId: Int): List<Timeline> {
        return tlRepo.findListByUserId(userId)
    }

    override fun getListByTask(taskId: Int): List<Timeline> {
        return tlRepo.findListByTaskId(taskId)
    }

    override fun getTimelineById(logId: Int): Timeline? {
        return tlRepo.findById(logId)
    }

    override fun thinkingLogPost(post: Thinkinglog): Int {
        val insertId = tlRepo.insertPost(post)
        val tl = getTimelineById(insertId)

        tl?.let {
            val notifyUsersId = tl.taskid?.let { taskId -> userRepo.findByTaskId(taskId).map { user -> user.userId } }
                ?: listOf(tl.userid)
            notifyMessage(notifyUsersId, TlInfo(it))
        }

        return insertId
    }

    override fun sseTimelineRegister(userId: Int, taskId: Int?): SseEmitter {
        val key = EmitterMapKey(userId, taskId)
        val emitter = SseEmitter(sseTimeout.toLong())
        emitter.onCompletion { timelineEmitters.remove(key) }
        emitter.onTimeout { timelineEmitters.remove(key) }

        if(timelineEmitters[key] != null){
            timelineEmitters[key]?.add(emitter)
        }else{
            timelineEmitters[key] = mutableListOf(emitter)
        }

        val msg = if(taskId == null){
            GetTlListResponse(getList(userId).map { TlInfo(it) })
        }else{
            GetTlListResponse(getListByTask(taskId).map { TlInfo(it) })
        }

        emitter.send(SseEmitter.event().name("init").data(msg))

        return emitter
    }

    override fun notifyMessage(userIds: List<Int>, msg: TlInfo) {
        val taskId = msg.taskid
        val emitters: MutableList<SseEmitter> = mutableListOf()

        userIds.forEach{ userId ->
            timelineEmitters[EmitterMapKey(userId, taskId)]?.forEach { emitters.add(it) }
            taskId?.let { timelineEmitters[EmitterMapKey(userId, null)]?.forEach { emitters.add(it) } }
        }

        emitters.forEach{
            it.send(SseEmitter.event().name("new").data(msg))
        }
    }


    /** SseEmitterのkeyクラス */
    private data class EmitterMapKey(
        val userId: Int,
        val taskId: Int?
    )
}