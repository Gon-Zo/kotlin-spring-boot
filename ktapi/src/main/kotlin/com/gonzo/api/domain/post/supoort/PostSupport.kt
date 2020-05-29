package com.gonzo.api.domain.post.supoort

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
@Transactional(readOnly = true)
class PostSupport ( val jpaQueryFactory: JPAQueryFactory , val entityManager: EntityManager){

    fun update(){
//       jpaQueryFactory.update()
    }


    fun findByPage(){
//        jpaQueryFactory.selectFrom(QPost)
    }


}
