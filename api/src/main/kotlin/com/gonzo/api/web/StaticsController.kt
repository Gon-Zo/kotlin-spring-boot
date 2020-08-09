package com.gonzo.api.web

import com.gonzo.api.service.user.UserService
import com.gonzo.api.web.dto.UserDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/statics")
class StaticsController (private val userService: UserService){

    @PostMapping("/user")
    fun createByUser(@RequestBody dto: UserDto) {
        userService.createdByUser(dto)
    }

}
