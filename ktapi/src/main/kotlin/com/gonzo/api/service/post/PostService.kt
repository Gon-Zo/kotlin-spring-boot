package com.gonzo.api.service.post

import com.gonzo.api.domain.post.Post
import com.gonzo.api.domain.post.PostRepository
import com.gonzo.api.web.dto.PostDto
import org.springframework.stereotype.Service

@Service
class PostService(val postRepository: PostRepository) {

    fun getPost(): List<Post> {
        return postRepository.findAll()
    }

    fun creatPost(dto : PostDto) {
        postRepository.save(dto.toEntity())
    }

    fun deleteById( seq : Long ){
        postRepository.deleteById(seq)
    }

    fun updateByPost( seq : Long , dto : PostDto){
    }

}