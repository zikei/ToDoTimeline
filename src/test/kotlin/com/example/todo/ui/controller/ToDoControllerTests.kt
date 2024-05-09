package com.example.todo.ui.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.servlet.view.InternalResourceViewResolver


@SpringBootTest
class ToDoControllerTests {
    private val todoController = ToDoController()
    private lateinit var mockMvc : MockMvc

    @BeforeEach
    fun setup() {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".html")
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).setViewResolvers(viewResolver).build()
    }

    // TODO: 本来は認証が必要なため認証機能追加時テストを変更
    @Test
    fun `todo page is success`() {
        mockMvc.get("/todo")
            .andExpect {
                status {
                    status { isOk() }
                    view { name("todo") }
                }
            }
    }
}