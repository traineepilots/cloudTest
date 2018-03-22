package com.zhou

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.ribbon.proxy.annotation.Hystrix
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@EnableEurekaClient
@RestController
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
class EurekaclientApplication {

    @Value("\${server.port}")
    internal var port : String? = null

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    fun home(@RequestParam name : String) : String {
        return "hi $name,i am from port:$port"
    }

    fun hiError(name : String) : String {
        return "hi,$name,sorry,error!"
    }
}

fun main(args : Array<String>) {
    SpringApplication.run(EurekaclientApplication::class.java , *args)
}