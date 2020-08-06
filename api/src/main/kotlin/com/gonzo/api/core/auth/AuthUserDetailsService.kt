package com.gonzo.api.core.auth

import com.gonzo.api.domain.user.User
import com.gonzo.api.domain.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

/**
 * Create by park031517@gmail.com on 2020-07-30, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class AuthUserDetailsService(private var userRepository : UserRepository) : UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {

        var user: User = userRepository.findByEmail(username);

        var authUser : AuthUserDetails = AuthUserDetails(user.email!! , user.password!!)

        return authUser
    }

}
