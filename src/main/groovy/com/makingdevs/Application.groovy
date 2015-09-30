package com.makingdevs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.ApplicationContext

class ExampleApplication {

    static void main(String[] args) {
      println "Hola inmundo"
      ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
      def repository = ctx.getBean("customerRepository")
      def customer = new Customer(firstName:"tu",lastName:"mama")
      println customer
      println repository.save(customer)
      println "fin"
    }
}