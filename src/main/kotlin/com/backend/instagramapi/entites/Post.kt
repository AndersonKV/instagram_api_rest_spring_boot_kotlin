package com.backend.instagramapi.entites

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "tb_post_kl")
data class Post(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Lob
    var content: String,

    var photo: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    var user: User?,
)
