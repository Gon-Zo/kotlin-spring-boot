package com.gonzo.api.domain.user.support

import com.gonzo.api.domain.user.QUser.user
import com.gonzo.api.domain.user.User
import com.gonzo.api.web.dto.UserDto
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager
import org.apache.commons.lang3.StringUtils.isNotEmpty
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * Create by park031517@gmail.com on [2020-08-6, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
class UserSupportImpl(entityManager : EntityManager , jpaRepositoryFactory: JpaRepositoryFactory) : UserSupport , QuerydslRepositorySupport(User::class.java) {

    @Transactional
    override fun update(seq: Long , dto : UserDto) {

        var query = update(user)

        if(isNotEmpty(dto.email)){
            query.set( user.email , dto.email)
        }

        if(isNotEmpty(dto.password)){
           query.set(user.password  , dto.password)
        }

        query.execute();

    }

}
