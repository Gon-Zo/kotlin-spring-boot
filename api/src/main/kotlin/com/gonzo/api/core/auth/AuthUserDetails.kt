package com.gonzo.api.core.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

/**
 * Create by park031517@gmail.com on 2020-08-6, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class AuthUserDetails : UserDetails {

    private var email: String? = null;

    private var password: String? = null;

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val auth = ArrayList<GrantedAuthority>()
        auth.add(SimpleGrantedAuthority("USER"))
        return auth
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.email!!
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.password!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}
