package com.example.todo.ui.controller

import com.example.todo.domain.service.TimelineService
import com.example.todo.ui.form.RegisterPostRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/timeline")
class TimelineController(
    @Autowired private val tlService: TimelineService
) {
    @ModelAttribute
    fun setupRegisterPostRequest(): RegisterPostRequest{
        return RegisterPostRequest()
    }

    /** タイムライン */
    @GetMapping
    fun timeline(): String{
        return "timeline"
    }
}