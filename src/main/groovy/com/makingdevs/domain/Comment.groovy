package com.makingdevs.domain

import org.springframework.data.annotation.Id
import javax.persistence.*
import org.springframework.data.mongodb.core.mapping.Document
import com.mongodb.*

@Document
public class Comment {

  @Id
  String id

  String title
  String body

}