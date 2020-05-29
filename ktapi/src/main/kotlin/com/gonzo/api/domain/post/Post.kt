package com.gonzo.api.domain.post

import com.gonzo.api.domain.BaseEntity
import com.querydsl.core.annotations.QueryEntities
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name="POST")
@NoArgsConstructor
//@QueryEntities()
class Post : BaseEntity {

    @Column(name = "title")
    var title : String ?= null

    @Column(name = "content")
    var content : String ?= null

    constructor(title : String  , content : String){
        this.title = title
        this.content = content
    }

}
