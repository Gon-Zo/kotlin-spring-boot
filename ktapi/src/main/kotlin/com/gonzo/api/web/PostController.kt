package com.gonzo.api.web

import com.gonzo.api.domain.post.Post
import com.gonzo.api.service.post.PostService
import com.gonzo.api.web.dto.PostDto
import org.springframework.web.bind.annotation.*

@RequestMapping("/post")
@RestController
class PostController (val postService: PostService){

    @GetMapping("")
    fun showPosts() : List<Post>{
       return postService.getPost();
    }


    @PostMapping("")
    fun makePost(@RequestBody dto : PostDto){
        postService.creatPost(dto)
    }

}