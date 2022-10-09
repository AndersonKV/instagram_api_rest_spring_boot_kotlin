package com.backend.instagramapi.entites

import javax.persistence.*

@Entity(name = "tb_user_kl")
class User(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

//    @Column(name = "published")
//    var twoFact: Boolean = false,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val posts: List<Post>?
)

//class UserDTO(
//    @field:Id
//    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
//
//    @Column(name = "name")
//    var name: String,
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
//    val posts: List<Post>?
//)