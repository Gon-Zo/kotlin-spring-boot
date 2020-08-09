package com.gonzo.api.domain.menugroup

import com.gonzo.api.domain.BaseEntity
import com.gonzo.api.domain.group.Group
import com.gonzo.api.domain.menu.Menu
import javax.persistence.*

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name = "APP_MENU_GROUP")
class MenuGroup : BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var seq : Long ?= null

    @OneToOne
    private var group : Group

    @OneToOne
    private var menu : Menu

    constructor(menu: Menu, group : Group) {
        this.menu = menu
        this.group = group
    }

}
