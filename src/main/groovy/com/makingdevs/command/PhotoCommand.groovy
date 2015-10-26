package com.makingdevs.command

class PhotoCommand{

  String title
  String url
  String thumbnailUrl

  PhotoCommand jsonConverter (def jsonObject){
    this.title = jsonObject.title
    this.url = jsonObject.url
    this.thumbnailUrl = jsonObject.thumbnailUrl
    this
  }

}