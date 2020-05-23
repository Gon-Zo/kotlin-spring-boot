package com.gonzo.api.domain.post.supoort

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class PostSupport ( val jpaQueryFactory: JPAQueryFactory , val entityManager: EntityManager){

    fun update(){
//       jpaQueryFactory.update()
    }


    fun findByPage(){
//        jpaQueryFactory.selectFrom(QPost)
    }


}
