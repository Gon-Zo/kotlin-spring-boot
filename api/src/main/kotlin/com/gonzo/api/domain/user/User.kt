package com.gonzo.api.domain.user

import com.gonzo.api.domain.BaseEntity
import org.hibernate.annotations.DynamicUpdate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@Table(name="APP_USER")
@DynamicUpdate
class User : BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private var seq : Long ?= null

    @Column(nullable = false)
     var email : String ?= null

    @Column(nullable = false)
     var password : String ?= null

    constructor( email : String  , password  : String){
        this.email =  email
        this.password = password
    }

}
