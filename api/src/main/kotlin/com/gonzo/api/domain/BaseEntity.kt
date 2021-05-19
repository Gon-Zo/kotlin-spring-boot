package com.gonzo.api.domain

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@MappedSuperclass
abstract class BaseEntity {

    @Column(nullable = false)
    protected var createdDate: LocalDate? = null
        get() {
            return this.createdDate
        }

    @Column(nullable = false)
    protected var updatedDate: LocalDate? = null
        get() {
            return this.updatedDate
        }

    @PrePersist
    protected fun getPersist() {
        createdDate = LocalDate.now()
        updatedDate = LocalDate.now()
    }

    @PreUpdate
    protected fun getUpdate() {
        this.updatedDate = LocalDate.now()
    }
}
