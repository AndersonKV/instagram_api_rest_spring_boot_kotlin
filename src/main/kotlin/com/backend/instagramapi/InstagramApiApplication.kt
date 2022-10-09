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





@SpringBootApplication
class InstagramApiApplication

fun main(args: Array<String>) {
    runApplication<InstagramApiApplication>(*args)
}
