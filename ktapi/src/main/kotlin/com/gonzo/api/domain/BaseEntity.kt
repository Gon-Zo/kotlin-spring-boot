package com.gonzo.api.domain

import java.time.LocalDate
import javax.persistence.*


/**
 * Base Entity
 * Table Columns is Base Entity
 *
 * @author jkPark
 */
@MappedSuperclass
open class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq : Long = 0L

    @Column(updatable = false, nullable = false)
    var createdAt: LocalDate? = null

    @Column(nullable = false)
    var updatedAt: LocalDate? = null

    @PrePersist
    fun onPersist() {
        updatedAt = LocalDate.now()
        createdAt = updatedAt
    }

    @PreUpdate
    fun onUpdate() {
        updatedAt = LocalDate.now()
    }

}

