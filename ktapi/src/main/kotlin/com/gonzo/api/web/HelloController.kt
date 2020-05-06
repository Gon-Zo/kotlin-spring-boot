package com.gonzo.api.web

import com.gonzo.api.web.dto.HelloDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hello")
class HelloController {


    @GetMapping("")
    fun getHello(): String {
        return "Hello"
    }

    @PostMapping("/")
    fun postHello(@RequestBody dto: HelloDto): HelloDto {
        return dto
    }

}
