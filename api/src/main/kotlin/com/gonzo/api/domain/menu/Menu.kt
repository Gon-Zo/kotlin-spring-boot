package com.gonzo.api.domain.menu

import com.gonzo.api.domain.BaseEntity
import javax.persistence.*

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name = "APP_MENU")
class Menu : BaseEntity {

    constructor(url: String, isUse: Boolean) {
        this.url = url
        this.isUse = isUse
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var seq: Long? = null

    @Column(nullable = false)
    private var url: String

    @Column(nullable = false)
    private var isUse: Boolean? = false


}
