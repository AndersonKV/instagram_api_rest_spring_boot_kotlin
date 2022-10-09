package com.backend.instagramapi.repository

import com.backend.instagramapi.entites.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : CrudRepository<Post, Long> {

}