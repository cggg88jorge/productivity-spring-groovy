package com.makingdevs

import org.springframework.data.annotation.Id

public class Customer {

  @Id
  String id

  String firstName
  String lastName

}