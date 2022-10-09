package com.backend.instagramapi.controllers;


import com.backend.instagramapi.entites.User
import com.backend.instagramapi.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = arrayOf("user"))
class UserController {
    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping("/create")
    fun create(@RequestBody user: User): User {
        return this.userRepository.save(user);
    }

    @GetMapping("/me")
    fun findAllUsersAndRelations(): MutableIterable<User> {
        return this.userRepository.findAll();
    }

    @GetMapping()
    fun findAllUsers(): MutableIterable<User> {
        return this.userRepository.findAll();
    }
}
