package com.gonzo.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Configuration
class JpaConfiguration {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Bean
    fun setJpaRepositoryFactory(): JpaRepositoryFactory {
        return JpaRepositoryFactory(this.entityManager)
    }

}
