package com.example.todo.ui.controller

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest
class HomeControllerTests {
    private val homeController = HomeController()
    private val mockMvc = MockMvcBuilders.standaloneSetup(homeController).build()

    @Test
    fun `home page is success`() {
        mockMvc.get("/")
            .andExpect {
                status { isOk() }
            }
    }
}