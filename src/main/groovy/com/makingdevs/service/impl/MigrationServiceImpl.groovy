package com.makingdevs.service.impl

import org.springframework.beans.factory.annotation.Autowired
import com.makingdevs.service.MigrationService
import org.springframework.stereotype.Service

@Service
class MigrationServiceImpl implements MigrationService{

  def initMiration(){
    println "empieza la migracion"
  }

}