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
class ServiceHiApplication {

    companion object {
        private val log = Logger.getLogger(ServiceHiApplication::class.java.name)
    }

    @Autowired
    private val restTemplate : RestTemplate? = null

    @Bean
    fun getRestTemplate() : RestTemplate {
        return RestTemplate()
    }

    @RequestMapping("/hi")
    fun callHome() : String {
        log.log(Level.INFO , "calling trace service-hi")
        return restTemplate!!.getForObject("http://localhost:8989/miya" , String::class.java)
    }

    @RequestMapping("/hi2")
    fun info() : String {
        log.log(Level.INFO , "calling trace service-hi")
        return "i'm service-hi"
    }

    @Bean
    fun defaultSampler() : AlwaysSampler {
        return AlwaysSampler()
    }
}

fun main(args : Array<String>) {
    SpringApplication.run(ServiceHiApplication::class.java , *args)
}
