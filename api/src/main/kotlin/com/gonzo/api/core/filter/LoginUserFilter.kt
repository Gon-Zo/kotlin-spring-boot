package com.gonzo.api.core.filter

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginUserFilter : UsernamePasswordAuthenticationFilter() {

    init {

    }



    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {



        return super.attemptAuthentication(request, response)
    }



}
