package com.gonzo.api.domain.post

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table
@NoArgsConstructor
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq : Long = 0L

    @Column(name = "title")
    var title : String ?= null

    @Column(name = "content")
    var content : String ?= null

    constructor(title : String  , content : String){
        this.title = title
        this.content = content
    }

}