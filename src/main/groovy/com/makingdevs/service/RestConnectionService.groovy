package com.makingdevs.service

interface RestConnectionService {

  def get(String endpoint, Map query)

  def post(String endpoint, Map query)

  def put(String endpoint, Map query)

}