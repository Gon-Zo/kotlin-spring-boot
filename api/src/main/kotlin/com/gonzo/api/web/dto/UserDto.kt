package com.gonzo.api.web.dto

import com.gonzo.api.domain.user.User

data class UserDto (val email : String = "" , val password: String = "") {
    fun toEntity(): User {
        return User(this.email, this.password)
    }
}
