package com.gonzo.api.domain.usergroup

import com.gonzo.api.domain.BaseEntity
import com.gonzo.api.domain.group.Group
import com.gonzo.api.domain.user.User
import javax.persistence.*

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name = "APP_USER_GROUP")
class UserGroup : BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val seq: Long? = null

    @OneToOne
    private var user: User

    @OneToOne
    private var group: Group

    constructor(user: User, group: Group) {
        this.user = user
        this.group = group
    }

}
