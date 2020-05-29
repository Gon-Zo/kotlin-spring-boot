package com.gonzo.api.web

import com.gonzo.api.domain.post.Post
import com.gonzo.api.service.post.PostService
import com.gonzo.api.web.dto.PostDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RequestMapping("/post")
@RestController
@CrossOrigin
class PostController (val postService: PostService){

    @GetMapping("")
    fun showPosts() : List<Post>{
       return postService.getPost();
    }

    @PostMapping("")
    fun makePost(@RequestBody dto : PostDto){
        postService.creatPost(dto)
    }

    @PutMapping("/{seq}")
    fun updatePost(@PathVariable seq: Long, @RequestBody dto: PostDto) {
        postService.updateByPost(seq, dto) ;
    }

    @DeleteMapping("/{seq}")
    fun removePost(@PathVariable seq: Long) {
        postService.deleteById(seq);
    }
//@PageableDefault(size=20, sort="name",direction = Sort.Direction.ASC)

    @GetMapping("/test")
    fun showPages(@PageableDefault(page = 0 , size = 10 , sort = ["seq"], direction = Sort.Direction.ASC)
                  pageable: Pageable): Page<Post> {
        return postService.getPageItems(pageable)
    }

}
