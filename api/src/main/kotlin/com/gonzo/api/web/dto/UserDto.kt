package com.gonzo.api.web.dto

import com.gonzo.api.domain.user.User

/**
 * Create by pnw1517@gmail.com on 2020-07-27, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class UserDto (val email : String = "" , val password: String = "") {
    fun toEntity(): User {
        return User(this.email, this.password)
    }
}
