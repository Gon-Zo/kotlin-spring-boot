package com.gonzo.api.domain.user.support

import com.gonzo.api.web.dto.UserDto

/**
 * Create by park031517@gmail.com on 2020-08-6, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
interface UserSupport {
    fun update(seq: Long, dto: UserDto)
}
