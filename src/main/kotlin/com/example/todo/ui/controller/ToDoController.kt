package com.example.todo.ui.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/todo")
class ToDoController {
    @GetMapping
    fun todoHome(): String{
        return "todo"
    }
}