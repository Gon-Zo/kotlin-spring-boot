package com.gonzo.api.core.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.gonzo.api.core.auth.AuthUserDetails
import com.gonzo.api.core.auth.JwtUtils
import com.gonzo.api.core.exception.AppException
import com.gonzo.api.core.exception.ErrorDto
import com.gonzo.api.core.utils.AppUtils
import com.gonzo.api.web.dto.RequestDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-07-29, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class LoginUserFilter(authenticationManager: AuthenticationManager, jwtUtils: JwtUtils) : UsernamePasswordAuthenticationFilter() {

    var jwtUtils: JwtUtils? = null

    init {
        setAuthenticationManager(authenticationManager)
        this.jwtUtils = jwtUtils
        setFilterProcessesUrl("/login");
    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {

        logger.info("FILTER -> LoginUserFilter")

        var requestBody = getRequestBodyToString(request!!)

        var email = AppUtils.passerJSONObject(requestBody!!, "email") as String

        var password = AppUtils.passerJSONObject(requestBody!!, "password") as String

        val authRequest = UsernamePasswordAuthenticationToken(email, password)

        setDetails(request, authRequest)

        return this.authenticationManager.authenticate(authRequest);

    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {

        var objectMapper = ObjectMapper()

        var autUserDetails: AuthUserDetails = authResult!!.principal as AuthUserDetails

        var email = autUserDetails.username

        val claims: MutableMap<String?, Any?> = HashMap()

        claims["email"] = email

        var jwt = jwtUtils!!.doGenerateToken(claims, email)

        response!!.outputStream
                .println(objectMapper
                        .writeValueAsString(RequestDto("500", jwt!!)))

    }

    override fun unsuccessfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, failed: AuthenticationException?) {
        super.unsuccessfulAuthentication(request, response, failed)

//        var objectMapper  = ObjectMapper()
//
//        var exception : AppException = failed!!.cause as AppException
//
//        var code =exception.errorCode.errorCode
//
//        var message  = exception.errorCode.message
//
//        response!!.outputStream.println(objectMapper.writeValueAsString(ErrorDto( code , message , "")))

    }

    private fun getRequestBodyToString(request: HttpServletRequest): String? {
        val jb = StringBuffer()
        var line: String? = null
        try {
            val reader = request.reader
            while (reader.readLine().also { line = it } != null) {
                jb.append(line)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return jb.toString()
    }

}

