package com.example.todo.ui.controller.api

import com.example.todo.domain.model.Login
import com.example.todo.domain.service.TimelineService
import com.example.todo.ui.form.GetTlListResponse
import com.example.todo.ui.form.TlInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/** ToDoコントローラ */
@RestController
@RequestMapping("/api/timeline")
class TimelineApiController(
    @Autowired private val tlService: TimelineService
) {
    /** タイムラインの取得 */
    @GetMapping("/list")
    fun getList(@AuthenticationPrincipal loginUser: Login): GetTlListResponse {
        val tlList = tlService.getList(loginUser.user.userId).map {
            TlInfo(it)
        }
        return GetTlListResponse(tlList)
    }
}