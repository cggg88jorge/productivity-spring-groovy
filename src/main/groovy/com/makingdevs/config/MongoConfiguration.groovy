package com.makingdevs.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import com.mongodb.*

@Configuration
@ComponentScan(basePackages = ["com.makingdevs.service"])
@EnableMongoRepositories(basePackages = "com.makingdevs.repository")
class MongoConfiguration extends AbstractMongoConfiguration {

    String getDatabaseName() {
        "local"
    }

    Mongo mongo() throws Exception {
        new MongoClient("127.0.0.1", 27017)
    }

    String getMappingBasePackage() {
        "com.makingdevs"
    }
}