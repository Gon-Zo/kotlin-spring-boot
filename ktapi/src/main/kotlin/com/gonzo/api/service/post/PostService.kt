package com.gonzo.api.service.post

import com.gonzo.api.domain.BaseEntity
import com.gonzo.api.domain.post.Post
import com.gonzo.api.domain.post.PostRepository
import com.gonzo.api.web.dto.PostDto
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
@Repository
class PostService(val postRepository: PostRepository) {

    fun getPost(): List<Post> {
        return postRepository.findAll()
    }

    fun creatPost(dto : PostDto) {
        postRepository.save(dto.toEntity())
    }

}