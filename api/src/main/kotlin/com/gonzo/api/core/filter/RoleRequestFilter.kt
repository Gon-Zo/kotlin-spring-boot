package com.gonzo.api.core.filter

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RoleRequestFilter() : OncePerRequestFilter(){

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        doFilter(request, response, filterChain)
    }

}
