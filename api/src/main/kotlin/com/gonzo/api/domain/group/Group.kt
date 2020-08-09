package com.gonzo.api.domain.group

import com.gonzo.api.domain.BaseEntity
import javax.persistence.*

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name="APP_GROUP")
class Group : BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var seq: Long ?= null

    @Column(nullable = false)
    private var title: String

    constructor(title : String){
       this.title = title
    }

}
