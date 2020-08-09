package com.gonzo.api.web.dto

import com.gonzo.api.domain.group.Group

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class GroupDto(var title : String){

    fun toEntity(): Group {
        return Group(this.title)
    }

}
