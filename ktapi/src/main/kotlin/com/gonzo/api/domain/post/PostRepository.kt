package com.gonzo.api.domain.post

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post , Long> {

    fun findBy( pageable: Pageable): Page<Post>
}
