package com.example.todo.ui.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/todo")
class TodoController {
    /** Todo一覧ページ */
    @GetMapping
    fun todoHome(): String {
        return "todo"
    }

    /** Todo詳細 */
    @GetMapping("/detail/{taskId}")
    fun todoDetail(@PathVariable("taskId") taskId: Int, model: Model): String {
        model.addAttribute("taskId", taskId)
        return "todoDetail"
    }

    /** Todo作成 */
    @GetMapping("/new")
    fun todoCreate(): String {
        return "todoCreate"
    }
}