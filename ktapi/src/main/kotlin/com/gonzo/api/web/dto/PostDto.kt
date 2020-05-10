package com.gonzo.api.web.dto

import com.gonzo.api.domain.post.Post

data class PostDto(var title: String, var content: String){

    fun toEntity() : Post{
        return Post(title , content)
    }

}
