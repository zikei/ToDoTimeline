package com.example.todo.app.service

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline
import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.domain.service.TimelineService
import com.example.todo.ui.form.TlInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class TimelineServiceImpl(
    @Autowired val tlRepo: TimelineRepository,
    @Value("\${sse.timeout}") private val sseTimeout: String
) : TimelineService {
    private val timelineEmitters: MutableMap<EmitterMapKey, SseEmitter> = mutableMapOf()

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
        return tlRepo.insertPost(post)
    }

    override fun sseTimelineRegister(userId: Int, taskId: Int?): SseEmitter {
        val key = EmitterMapKey(userId, taskId)
        val emitter = SseEmitter(sseTimeout.toLong())
        emitter.onCompletion { timelineEmitters.remove(key) }
        emitter.onTimeout { timelineEmitters.remove(key) }

        timelineEmitters[key] = emitter

        return emitter
    }

    override fun notifyMessage(userId: Int, taskId: Int?, msg: TlInfo) {
        val emitters: MutableList<SseEmitter> = mutableListOf()
        timelineEmitters[EmitterMapKey(userId, taskId)]?.let { emitters.add(it) }
        if(taskId != null) timelineEmitters[EmitterMapKey(userId, null)]?.let { emitters.add(it) }

        if(emitters.isNotEmpty()){
            emitters.forEach{
                it.send(SseEmitter.event().data(msg))
            }
        }
    }


    /** SseEmitterのkeyクラス */
    private data class EmitterMapKey(
        val userId: Int,
        val taskId: Int?
    )
}