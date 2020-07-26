package com.gonzo.api.web.dto

import com.gonzo.api.domain.user.User

data class UserDto(var email: String, var password: String) {

    fun toEntity(): User {
        return User(this.email, this.password)
    }
}
