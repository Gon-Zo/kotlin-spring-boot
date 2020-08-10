package com.gonzo.api.core.auth

import com.gonzo.api.core.exception.AppException
import com.gonzo.api.domain.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import com.gonzo.api.core.auth.AuthUserDetails as AuthUserDetails1

/**
 * Create by park031517@gmail.com on 2020-07-30, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class AuthUserDetailsService(private var userRepository : UserRepository) : UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {

        var user = userRepository.findByEmail(username);

        // todo : custom exception
        if(isNotIsUse(user.isUse)) {
            throw NullPointerException()
        }

        return AuthUserDetails1(user.email!! , user.password!!)
    }

    private fun isNotIsUse( isUse : Boolean) : Boolean{
        return !isUse
    }

}
