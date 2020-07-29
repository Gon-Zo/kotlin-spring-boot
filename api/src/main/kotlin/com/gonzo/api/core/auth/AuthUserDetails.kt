package com.gonzo.api.core.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


class AuthUserDetails : UserDetails {

    private var email: String? = null;

    private var password: String? = null;

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
        val auth = ArrayList<GrantedAuthority>()
        auth.add(SimpleGrantedAuthority(""))
        return auth
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override fun getUsername(): String? {
        TODO("Not yet implemented")
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override fun getPassword(): String? {
        TODO("Not yet implemented")
        return this.password
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
        return true
    }

}
