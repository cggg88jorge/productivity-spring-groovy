package com.makingdevs.config

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Bean
import com.mongodb.*

@Configuration
@ComponentScan(basePackages = ["com.makingdevs.service"])
@EnableMongoRepositories(basePackages = "com.makingdevs.repository")
class MongoConfiguration extends AbstractMongoConfiguration {

  private static final String PROPERTIES_FILE_URL = "${System.properties['user.home']}/.projects_config/productivity-spring-groovy.properties"

  String getDatabaseName() {
    "local"
  }

  Mongo mongo() throws Exception {
    new MongoClient("127.0.0.1", 27017)
  }

  String getMappingBasePackage() {
    "com.makingdevs"
  }

  @Bean
  def properties() {
    def file = new File(PROPERTIES_FILE_URL)
    new ConfigSlurper().parse(file.toURI().toURL())
  }

}