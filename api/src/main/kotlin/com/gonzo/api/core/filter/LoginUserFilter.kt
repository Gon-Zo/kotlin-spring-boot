package com.gonzo.api.core.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.gonzo.api.web.dto.RequestDto
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
//        usernameParameter = "email";
//        passwordParameter = "password";
        setFilterProcessesUrl("/api/login");
//        setPostOnly(true)
    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {

        logger.info("FILTER -> LoginUserFilter")

        var email = request!!.getParameter("email")

        var password = request!!.getParameter("password")

        val authRequest = UsernamePasswordAuthenticationToken(email, password)

        setDetails(request, authRequest)

        return this.authenticationManager.authenticate(authRequest);

    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {

        var objectMapper  = ObjectMapper()

        response!!.outputStream
                .println(objectMapper
                        .writeValueAsString(RequestDto("500" , "SUCCESS")))

    }

    override fun unsuccessfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, failed: AuthenticationException?) {
        super.unsuccessfulAuthentication(request, response, failed)
    }

}
