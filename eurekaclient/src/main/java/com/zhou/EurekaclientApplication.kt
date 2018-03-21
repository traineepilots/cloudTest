package com.zhou

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@EnableEurekaClient
@RestController
@SpringBootApplication
class EurekaclientApplication {

    @Value("\${server.port}")
    internal var port : String? = null

    @RequestMapping("/hi")
    fun home(@RequestParam name : String) : String {
        return "hi $name,i am from port:$port"
    }
}

fun main(args : Array<String>) {
    SpringApplication.run(EurekaclientApplication::class.java , *args)
}