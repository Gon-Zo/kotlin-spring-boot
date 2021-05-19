package com.gonzo.api.web.dto

import com.gonzo.api.domain.user.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 * Create by park031517@gmail.com on 2020-07-27, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class UserDto(var email: String, var password: String, var isUse: Boolean) {

    fun toEntity(): User {
        return User(this.email, this.password, isUse)
    }

    fun encodingPassword() {
        this.password = BCryptPasswordEncoder().encode(this.password)
    }

    fun isUseToUser() {
        this.isUse = true
    }

    fun isNotUseToUser() {
        this.isUse = false
    }

}
