package com.gonzo.api.web

import com.gonzo.api.service.user.UserService
import com.gonzo.api.web.dto.UserDto
import org.springframework.web.bind.annotation.*

/**
 * Create by pnw1517@gmail.com on 2020-07-27, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/user")
class UserController {

    private lateinit var service : UserService

    @ResponseBody
    @PostMapping("")
    fun createByUser( dto : UserDto){
        service.createdByUser(dto)
    }

    @DeleteMapping("/{seq}")
    fun removeByUser(@PathVariable seq: Long) {
        service.deleteByUser(seq)
    }

}
