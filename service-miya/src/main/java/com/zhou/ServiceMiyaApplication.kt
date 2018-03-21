package com.zhou

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.sleuth.sampler.AlwaysSampler
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.util.logging.Level
import java.util.logging.Logger

@SpringBootApplication
@RestController
class ServiceMiyaApplication {

    companion object {
        private val log = Logger.getLogger(ServiceMiyaApplication::class.java.name)
    }

    @Autowired
    private val restTemplate : RestTemplate? = null

    @RequestMapping("/hi")
    fun home() : String {
        log.log(Level.INFO , "hi is being called")
        return "hi i'm miya"
    }

    @RequestMapping("/miya")
    fun info() : String {
        log.log(Level.INFO , "info is being called")
        return restTemplate!!.getForObject("http://localhost:8988/hi2" , String::class.java)
    }

    @Bean
    fun getRestTemplate() : RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun defaultSampler() : AlwaysSampler {
        return AlwaysSampler()
    }
}

fun main(args : Array<String>) {
    SpringApplication.run(ServiceMiyaApplication::class.java , *args)
}


