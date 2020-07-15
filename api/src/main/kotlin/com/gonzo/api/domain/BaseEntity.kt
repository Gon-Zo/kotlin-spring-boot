package com.gonzo.api.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , nullable = false)
    private var id : Long = 0

    @Column(name = "CREATE_DATE")
    protected var createDate : LocalDate ?= null

    @Column(name = "UPDATE_DATE")
    protected var updateDate: LocalDate? = null

    @PrePersist
    protected fun onCreate() {
        this.createDate = LocalDate.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        this.updateDate = LocalDate.now()
    }

}
