package com.gonzo.api.core.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * Create by park031517@gmail.com on 2020-07-30, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */

class AuthUserDetailsService : UserDetailsService{

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")

        var test : String = ""

    }

}
