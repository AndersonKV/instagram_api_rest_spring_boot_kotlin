package com.backend.instagramapi.controllers

import com.backend.instagramapi.entites.Post
import com.backend.instagramapi.entites.User
import com.backend.instagramapi.repository.PostRepository
import com.backend.instagramapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = arrayOf("post"))
class PostController {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var postRepository: PostRepository


    @PostMapping("/create")
    fun create(
        @RequestBody post: Post,
        @RequestParam("id") id: Long
    ): Post {

        var user = this.userRepository.findById(id).get()

        post.user = user;

        return this.postRepository.save(post);
    }

//    @GetMapping
//    fun FindAll(): MutableIterable<User> {
//        return this..findAll();
//    }
}