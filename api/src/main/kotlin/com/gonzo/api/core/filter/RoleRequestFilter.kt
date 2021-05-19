package com.gonzo.api.core.filter

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-08-11, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class RoleRequestFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        var securityContextHolder = SecurityContextHolder.getContext()

        var authentication = securityContextHolder.authentication

        var principal = authentication.principal

        doFilter(request, response, filterChain)
    }

}
