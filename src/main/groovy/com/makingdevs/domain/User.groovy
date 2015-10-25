package com.makingdevs.domain

import org.springframework.data.annotation.Id
import javax.persistence.*

public class User {

  @Id
  String id

  String name
  String username
  String email

  @OneToMany(mappedBy = "user")
  Set<Comment> comments = new ArrayList<Comment>()

}