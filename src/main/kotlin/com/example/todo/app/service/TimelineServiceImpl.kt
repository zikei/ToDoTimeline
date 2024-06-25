package com.example.todo.app.service

import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.model.Timeline
import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.domain.service.TimelineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimelineServiceImpl(
    @Autowired val tlRepo: TimelineRepository
) : TimelineService {
    override fun getList(userId: Int): List<Timeline> {
        return tlRepo.findListByUserId(userId)
    }

    override fun thinkingLogPost(post: Thinkinglog): Int {
        return tlRepo.insertPost(post)
    }
}