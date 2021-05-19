package com.gonzo.api.core.filter

import com.gonzo.api.core.auth.AuthUserDetailsService
import com.gonzo.api.core.auth.JwtUtils
import com.gonzo.api.core.exception.AppException
import com.gonzo.api.core.exception.ErrorCode
import com.gonzo.api.core.utils.AppUtils
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.lang.IllegalStateException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
//todo : 결과값 변경
@Component
class JwtRequestFilter(detailsService: AuthUserDetailsService, jwtUtils: JwtUtils) : OncePerRequestFilter() {

    private var detailsService: AuthUserDetailsService? = null

    private var jwtUtils: JwtUtils? = null

    init {
        this.detailsService = detailsService
        this.jwtUtils = jwtUtils
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        var url = request.requestURI

        var headerAuthorization: String? = null

        var userName: String? = null

        if (url.startsWith("/statics")) {
            filterChain.doFilter(request, response)
        }

        try {

            try {
                headerAuthorization = request.getHeader("Authorization").substring(7)
            } catch (e: IllegalStateException) {
                throw AppException(ErrorCode.NOT_FOUND_TOKEN)
            }

            try {
                userName = jwtUtils!!.getUsernameFromToken(headerAuthorization)
            } catch (e: IllegalArgumentException) {
                throw AppException(ErrorCode.UNABLE_JWT_TOKEN)
            } catch (e: ExpiredJwtException) {
                throw AppException(ErrorCode.EXPIRED_JWT_TOKEN)
            }

            var authUser = detailsService!!.loadUserByUsername(userName)

            if (isNotValidateToken(headerAuthorization, authUser)) {
                throw AppException(ErrorCode.IS_NOT_VALIDATE)
            } else {

                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(authUser, null, authUser.authorities)

                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken

                filterChain.doFilter(request, response)

            }

        } catch (ae: AppException) {
            logger.error(ae.printStackTrace())
            AppUtils.getBadRequest(ae, response)
        }

    }

    fun isNotValidateToken(headerAuthorization: String, authUser: UserDetails): Boolean {
        return !jwtUtils!!.validateToken(headerAuthorization, authUser)!!
    }

}
