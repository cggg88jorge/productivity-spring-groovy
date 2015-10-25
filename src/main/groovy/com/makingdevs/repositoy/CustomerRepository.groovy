package com.makingdevs.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.makingdevs.domain.Customer

interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName)

}