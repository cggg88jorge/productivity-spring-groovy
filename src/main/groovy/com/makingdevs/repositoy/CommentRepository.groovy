package com.makingdevs.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.makingdevs.domain.Comment

interface CommentRepository extends MongoRepository<Comment, String> {

}