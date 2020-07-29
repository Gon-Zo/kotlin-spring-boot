package com.gonzo.api.core.filter

import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsUtils
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Component
class CorsFilter : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        var httpServletResponse : HttpServletResponse  = response as HttpServletResponse

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*")
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600")
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With")
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "false")

        if(CorsUtils.isPreFlightRequest(request as HttpServletRequest)){
           return
        }

        chain!!.doFilter(request, response);
    }

}
