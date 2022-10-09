package com.backend.instagramapi.repository

import com.backend.instagramapi.entites.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, Long> {

}