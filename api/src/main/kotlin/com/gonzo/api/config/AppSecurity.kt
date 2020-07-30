package com.gonzo.api.config

import com.gonzo.api.core.filter.CorsFilter
import com.gonzo.api.core.filter.JwtRequestFilter
import com.gonzo.api.core.filter.LoginUserFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Configuration
@EnableWebSecurity
class AppSecurity(private val corsFilter: CorsFilter,
                  private val jwtRequestFilter: JwtRequestFilter,
                  private val jwtUserDetailsService: UserDetailsService,
                  private val beanConfiguration: BeanConfiguration
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {

        http!!.csrf()
                .disable()
                .addFilterBefore(corsFilter, BasicAuthenticationFilter::class.java)
                .addFilterBefore(LoginUserFilter(authenticationManager()) , CorsFilter::class.java)
                .addFilterAfter(jwtRequestFilter, LoginUserFilter::class.java)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)


    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"
        );
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(beanConfiguration.passwordEncoder())
    }

}
