package com.makingdevs.service.actor

import groovyx.gpars.actor.DefaultActor
import org.springframework.stereotype.Service

@Service
class DelegateActor extends DefaultActor {

    @Override
    protected void act() {
        loop {
            react { Map data ->
                try {
                    println data
                } catch (Exception e) {
                    e.printStackTrace()
                    println "error"
                }
            }
        }
    }
}