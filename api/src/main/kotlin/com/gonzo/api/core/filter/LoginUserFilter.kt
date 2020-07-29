package com.gonzo.api.core.filter

import org.apache.tomcat.jni.User.username
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-07-29, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class LoginUserFilter ( authenticationManager : AuthenticationManager) : UsernamePasswordAuthenticationFilter() {

    init {
        setAuthenticationManager(authenticationManager)
        usernameParameter = "email";
        passwordParameter = "password";
        setPostOnly(true)
        setFilterProcessesUrl("/api/login");

    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {

        logger.info("===== LoginUserFilter =====" )

        var email : String = request!!.getParameter("email")

        var password : String = request!!.getParameter("password")

        val authRequest = UsernamePasswordAuthenticationToken(email, password)

        return this.authenticationManager.authenticate(authRequest);

    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        super.successfulAuthentication(request, response, chain, authResult)
    }

    override fun unsuccessfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, failed: AuthenticationException?) {
        super.unsuccessfulAuthentication(request, response, failed)
    }

}
