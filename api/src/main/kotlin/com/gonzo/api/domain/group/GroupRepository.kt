package com.gonzo.api.domain.group

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
interface GroupRepository : JpaRepository<Group, Long> {
    fun findByTitle(title: String): Group
}
