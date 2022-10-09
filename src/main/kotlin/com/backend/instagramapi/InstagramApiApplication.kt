package com.backend.instagramapi

import com.fasterxml.jackson.annotation.JsonIgnore
import jdk.jshell.execution.Util
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

import javax.persistence.*

@Entity(name = "tb_post_kl")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    var id: Long? = null,

    @Lob
    var content: String,

    var photo: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    var user: User?,
)

@Entity(name = "tb_user_kl")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "published")
    var twoFact: Boolean = false,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val posts: List<Post>?

    )

@Repository
interface UserRepository : CrudRepository<User, Long> {

}

@Repository
interface PostRepository : CrudRepository<Post, Long> {

}

@RestController
class TestController {
    @Autowired
    lateinit var userRepositry: UserRepository;

    @Autowired
    lateinit var postRepository: PostRepository;

//    @GetMapping("/")
//    fun test(): MutableIterable<User> {
//        var users = this.userRepositry.findAll();
//
//         return users;
//    }


    @PostMapping("/user/create")
    fun createUser(@RequestBody user: User): User {
        return this.userRepositry.save(user);
    }

    @PostMapping("/post/create")
    fun createPost(@RequestBody post: Post,
                   @RequestParam("id") id: Long): Post {
        var user = this.userRepositry.findById(id).get();

        post.user = user;
         // val user = User(name = "");
//        var find = this.userRepositry.findById(id);
//        post.user = find.get();
       return this.postRepository.save(post);

//        return this.userRepositry.findById(1).isPresent()map{ user -> {
//            post.user = user;
//            //return this.postRepository.save(post);
//            return post;
//        }}.orElseThrow { RuntimeException() }

//        @RequestBody Comment commentRequest) {
//            Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
//            commentRequest.setTutorial(tutorial);
//            return commentRepository.save(commentRequest);
//        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
//
//            return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }


    @PatchMapping("/post/{id}")
    fun postUp(@RequestBody post: Post,
                   @PathVariable("id") id: Long): Post {

       var user = this.userRepositry.findById(id).get()

        var updatedPost = Post(
            id = id,
            content = post.content,
            photo = post.photo,
            user
         )

        return this.postRepository.save(updatedPost);
    }

    @GetMapping("/user")
    fun findUsers(): MutableIterable<User> {
        return this.userRepositry.findAll();
    }

    @GetMapping("/post")
    fun findPosts(): MutableIterable<Post> {
        return this.postRepository.findAll();
    }
}

@SpringBootApplication
class InstagramApiApplication

fun main(args: Array<String>) {
    runApplication<InstagramApiApplication>(*args)
}
