package com.example.todo.ui.config

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.core.io.ClassPathResource
import java.io.IOException
import java.util.*


@Configuration
class MessageSourceConfig {
    @Bean(name = ["messagesProperties"])
    @Throws(IOException::class)
    fun yamlProperties(): Properties? {
        val bean = YamlPropertiesFactoryBean()
        bean.setResources(ClassPathResource("messages.yml"))
        return bean.getObject()
    }

    @Bean
    @Throws(IOException::class)
    fun messageSource(): MessageSource {
        val messageSource = ResourceBundleMessageSource()
        messageSource.setCommonMessages(yamlProperties())
        return messageSource
    }
}