package com.makingdevs.service.actor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import groovyx.gpars.actor.DefaultActor
import com.makingdevs.service.MigrationService

@Service
class DelegateActor extends DefaultActor {

  @Autowired
  MigrationService migrationService

  @Override
  protected void act() {
    loop {
      react { String username ->
        try {
          println "El actor entra en el proceso"
          migrationService.initMiration(username)
          } catch (Exception e) {
            println e.printStackTrace()
            println "error"
          }
        }
      }
    }
  }