package com.makingdevs.domain

import org.springframework.data.annotation.Id
import javax.persistence.*

public class Comment {

  @Id
  String id

  String title
  String body

  @ManyToOne
  @JoinColumn(name="user_id")
  User author

}