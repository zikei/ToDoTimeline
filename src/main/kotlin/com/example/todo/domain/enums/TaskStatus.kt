package com.example.todo.domain.enums

/**
 * タスク状態
 * open:進行中
 * closed:完了
 * cancel:中止
 */
enum class TaskStatus(val status: String, val statusName: String) {
    `open`("open","進行中"),
    closed("closed","完了"),
    cancel("cancel","中止")
}
