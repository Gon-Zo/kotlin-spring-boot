package com.gonzo.api.config

import com.gonzo.api.core.auth.AuthUserDetailsService
import com.gonzo.api.core.filter.JwtRequestFilter
import com.gonzo.api.core.filter.LoginUserFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Configuration
@EnableWebSecurity
class AppSecurity(
                  private val jwtRequestFilter: JwtRequestFilter,
                  private val authUserDetailsService: AuthUserDetailsService
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {

        http!!.csrf()
                .disable()
                .addFilterAfter(LoginUserFilter(authenticationManager()) , UsernamePasswordAuthenticationFilter::class.java)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)




//                .addFilterAfter(jwtRequestFilter, LoginUserFilter::class.java)


    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**", "/configuration/security", "/swagger-ui.html",
                "/webjars/**"
        );
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(authUserDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

}
