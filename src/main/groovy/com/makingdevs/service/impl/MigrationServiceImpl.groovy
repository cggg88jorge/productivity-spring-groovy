package com.makingdevs.service.impl

import org.springframework.beans.factory.annotation.Autowired
import com.makingdevs.service.RestConnectionService
import com.makingdevs.service.MigrationService
import org.springframework.stereotype.Service
import com.makingdevs.domain.*
import com.makingdevs.repository.*

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
    /*println userRepository.findAll().last().dump()
    println userRepository.findAllByUsername("cggg88jorge")*/
    def user = new User(name:"jorge",username:"cggg88jorge",email:"jorge@makingdevs.com")
    userRepository.save(user)
    def comment = new Comment(title:"tema",body:"lalalalalalalalal")
    commentRepository.save(comment)
    user.comments += comment
    userRepository.save(user)
    println user.dump()

    def user = restConnectionService.get("/users",[username:username])

    //buscar en la base
    // ir pot sus comentarios
    //generar estrucutra
    // gurdarlos
  }

}