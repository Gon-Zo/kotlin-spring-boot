package com.gonzo.api.domain.post

import com.gonzo.api.domain.BaseEntity
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "POST")
@NoArgsConstructor
class Post : BaseEntity {

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }

    @Column(name = "TITLE")
    private var title : String
        get() {
            return title
        }
        set(value) {
            this.title = value
        }

    @Column(name = "CONTENT")
    private var content : String ?= null
    get() {
       return this.content
    }
    set(value) {
        this.content = value
    }

}
