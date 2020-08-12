package com.gonzo.api

import com.gonzo.api.core.utils.InitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class ApiApplication {

    @Autowired
    private lateinit var initService: InitService

    @PostConstruct
    fun setUpInItData() {
        initService.initService()
    }

}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
