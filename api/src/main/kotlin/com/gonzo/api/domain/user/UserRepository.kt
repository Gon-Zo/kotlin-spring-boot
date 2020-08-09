package com.gonzo.api.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
interface UserRepository : JpaRepository<User , Long> {
    fun findByEmail(email: String): User
    fun findByUseIsTrueAnAndEmail(email : String) : User
}
