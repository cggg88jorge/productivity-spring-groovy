package com.makingdevs.service.impl

import org.springframework.beans.factory.annotation.Autowired
import com.makingdevs.service.RestConnectionService
import com.makingdevs.service.MigrationService
import org.springframework.stereotype.Service
import com.makingdevs.domain.*
import com.makingdevs.repository.*

import com.makingdevs.command.PostCommand
import com.makingdevs.command.PhotoCommand

@Service
class MigrationServiceImpl implements MigrationService{

  @Autowired
  UserRepository userRepository

  @Autowired
  CommentRepository commentRepository

  @Autowired
  RestConnectionService restConnectionService

  def initMiration(String username){
    println "empieza la migracion"
    def userRest = restConnectionService.get("/users",[username:username])

    def userMongo = userRepository.findByUsername(username)
    if(!userMongo){
      userMongo = new User(name:userRest.name,username:userRest.username,email:userRest.email)
      userRepository.save(userMongo)
    }
    def comments = restConnectionService.get("/comments",[postId:userRest.id])

    userMongo.comments += comments.collect { comment ->
      comment = new Comment(title:comment.name,body:comment.body)
      commentRepository.save(comment)
    }
    userRepository.save(userMongo)

    def posts = restConnectionService.get("/posts",[userId:userRest.id])
    def photos = restConnectionService.get("/photos",[albumId:userRest.id])

    def listPhotos = photos.collect{ photo ->
      new PhotoCommand().jsonConverter(photo)
    }

    def listPosts = posts.collect{ post ->
      new PostCommand().jsonConverter(post)
    }    

    // regresamos los datos
    def map = [listPhotos:listPhotos,listPosts:listPosts]
    println map
    println "fin"
  }

}