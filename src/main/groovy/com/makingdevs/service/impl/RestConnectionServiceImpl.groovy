package com.makingdevs.service.impl

import org.springframework.beans.factory.annotation.Autowired
import com.makingdevs.service.RestConnectionService
import org.springframework.stereotype.Service
import wslite.http.HTTPClientException
import wslite.rest.*

@Service
class RestConnectionServiceImpl implements RestConnectionService{

  @Autowired
  def properties

  def get(String endpoint, Map query = [:]){
    try{
      def client = new RESTClient(properties.url.api)
      def response = client.get(path:endpoint, query:query,
        headers:["Accept":"application/json; charset=utf-8"])
      response.json
    }catch (HTTPClientException e) {
      println e
      println endpoint
      println "query ${query}"
    }
  }

  def post(String endpoint, Map query = [:]){
    try{
      def client = new RESTClient(properties.url.api)
      def response = client.post(path:endpoint, query:query)
      response.json
    }catch (HTTPClientException e) {
      println e
      println endpoint
      println "query ${query}"
    }
  }

  def put(String endpoint, Map query = [:]){
    try{
      def client = new RESTClient(properties.url.api)
      def response = client.put(path:endpoint, query:query)
      response.json
    }catch (HTTPClientException e) {
      println e
      println endpoint
      println "query ${query}"
    }
  }

}