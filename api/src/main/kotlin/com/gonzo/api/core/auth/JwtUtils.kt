package com.gonzo.api.core.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Component
class JwtUtils {

    private val serialVersionUID = -2550185165626007488L

    private val JWT_TOKEN_VALIDITY = 5 * 60 * 60.toLong()

    @Value("\${jwt.secret}")
//    private lateinit var secret: String
    private val secret: String  ?= "testaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

    private fun getKeys(): ByteArray? {
        return secret!!.toByteArray()
    }

    // 토큰에서 정보를 검색하려면 비밀 키가 필요합니다
    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts
                .parser()
                .setSigningKey(getKeys())
                .parseClaimsJws(token)
                .body
    }

    // 토큰이 만료되었는지 확인
    private fun isTokenExpired(token: String?): Boolean? {
        val expiration = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    //토큰 확인
    fun validateToken(token: String?, userDetails: UserDetails): Boolean? {
        val username = getUsernameFromToken(token)
        return username == userDetails.username && isNotTokenExpired(token)
    }

    // jwt 토큰 만들기
    fun doGenerateToken(claims: Map<String?, Any?>?, subject: String?): String? {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, getKeys())
                .compact()
    }

    private fun isNotTokenExpired(token: String?): Boolean {
        return !isTokenExpired(token)!!
    }

    private fun <T> getClaimFromToken(token: String?, claimsResolver: Function<Claims, T>): T {
        val claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    //jwt 토큰에서 만료 날짜 검색
    private fun getExpirationDateFromToken(token: String?): Date {
        return getClaimFromToken(token, Function { obj: Claims -> obj.expiration })
    }

    //jwt 토큰에서 사용자 이름 검색
    fun getUsernameFromToken(token: String?): String {
        return getClaimFromToken(token, Function { obj: Claims -> obj.subject })
    }


}
