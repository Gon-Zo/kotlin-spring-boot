package com.gonzo.api.web.dto

import com.gonzo.api.domain.menu.Menu

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class MenuDto(var url: String, var isUse: Boolean) {

    fun toEntity(): Menu {
        return Menu(this.url, this.isUse)
    }

    fun isUseToMenu() {
        this.isUse = true
    }

    fun isNotUseToMenu() {
        this.isUse = false
    }

}
