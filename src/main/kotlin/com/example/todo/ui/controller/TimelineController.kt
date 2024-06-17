package com.example.todo.ui.controller

import com.example.todo.domain.service.TimelineService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/timeline")
class TimelineController(
    @Autowired private val tlService: TimelineService
) {

}