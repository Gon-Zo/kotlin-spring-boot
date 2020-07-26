package com.gonzo.api.domain.user

import com.gonzo.api.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Create by pnw1517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name="USER")
class User : BaseEntity {

    @Id
    private var sequence : Long ?= null

    @Column(nullable = false)
    private var email : String ?= null

    @Column(nullable = false)
    private var password : String ?= null

    constructor( email : String  , password  : String){
        this.email =  email
        this.password = password
    }

}
