package com.gonzo.api.service.user

import com.gonzo.api.web.dto.UserDto

/**
 * Create by pnw1517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
interface UserService {

    fun createdByUser(dto: UserDto)

    fun modifyByUser(seq : Long , dto: UserDto)

    fun deleteByUser(seq : Long)

    fun updateByUser(seq : Long  , dto: UserDto)

}
