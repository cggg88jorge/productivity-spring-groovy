package com.makingdevs.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.makingdevs.domain.User

interface UserRepository extends MongoRepository<User, String> {

  User findByUsername(String username)

}