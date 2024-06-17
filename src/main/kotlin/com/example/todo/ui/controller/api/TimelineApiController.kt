package com.example.todo.ui.controller.api

import com.example.todo.domain.service.TimelineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/** ToDoコントローラ */
@RestController
@RequestMapping("/api/tl")
class TimelineApiController(
    @Autowired private val tlService: TimelineService
) {

}