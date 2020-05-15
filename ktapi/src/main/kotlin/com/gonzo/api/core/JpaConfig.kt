package com.gonzo.api.core

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * JPAQueryFactory & EntityManager config
 *
 * @author jkpark
 */
@Configuration
class JpaConfig {

    @PersistenceContext
    lateinit var entitnManager: EntityManager

    @Bean
    fun jPAQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entitnManager)
    }

}