package com.example.todo.app.service

import com.example.todo.domain.repository.TimelineRepository
import com.example.todo.domain.service.TimelineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimelineServiceImpl(
    @Autowired val tlRepo: TimelineRepository
) : TimelineService {

}