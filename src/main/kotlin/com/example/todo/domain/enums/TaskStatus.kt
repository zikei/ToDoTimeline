package com.example.todo.domain.enums

/**
 * タスク状態
 * open:進行中
 * closed:完了
 * cancel:中止
 */
enum class TaskStatus(val status: String, val statusName: String, val weight: Int) {
    `open`("open","進行中", 3),
    closed("closed","完了", 2),
    cancel("cancel","中止", 1);

    companion object {
        fun getTaskStatus(key: String?): TaskStatus?{
            return TaskStatus.entries.find { it.status == key }
        }
    }
}
