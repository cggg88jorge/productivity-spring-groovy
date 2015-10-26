package com.makingdevs.command

class PostCommand{

  String title
  String body

  PostCommand jsonConverter (def jsonObject){
    this.title = jsonObject.title
    this.body = jsonObject.body
    this
  }

}