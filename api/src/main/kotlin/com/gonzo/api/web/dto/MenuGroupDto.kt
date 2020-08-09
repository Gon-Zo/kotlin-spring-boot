package com.gonzo.api.web.dto

import com.gonzo.api.domain.group.Group
import com.gonzo.api.domain.menu.Menu
import com.gonzo.api.domain.menugroup.MenuGroup

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class MenuGroupDto(var menu : Menu, var group : Group){
    fun toEntity () : MenuGroup{
       return MenuGroup(this.menu , this.group)
    }
}
