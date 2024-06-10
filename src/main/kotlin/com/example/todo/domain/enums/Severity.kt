package com.example.todo.domain.enums

/**
 * 重要度
 * urgent:緊急
 * high:高い
 * normal:通常
 * low:低い
 * none:なし
 */
enum class Severity(val severity: String, val severityName: String) {
    urgent("urgent", "緊急"),
    high("high", "高"),
    normal("normal", "中"),
    low("low", "低"),
    none("none", "なし");

    companion object {
        fun getSeverity(key: String?): Severity {
            key ?: return none
            return entries.find { it.severity == key } ?: none
        }
    }
}