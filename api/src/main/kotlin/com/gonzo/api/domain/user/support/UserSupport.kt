package com.gonzo.api.domain.user.support

import com.gonzo.api.web.dto.UserDto

interface UserSupport {
    fun update(seq : Long  , dto : UserDto)
}
