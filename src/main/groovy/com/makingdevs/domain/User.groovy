package com.makingdevs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DBRef
import com.mongodb.*

@Document
public class User {

  @Id
  String id

  String name
  String username
  String email

  @DBRef
  List<Comment> comments = new ArrayList<Comment>()

}