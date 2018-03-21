package com.zhou

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import zipkin.server.EnableZipkinServer

@SpringBootApplication
@EnableZipkinServer
class ServerZipkinApplication

fun main(args : Array<String>) {
    SpringApplication.run(ServerZipkinApplication::class.java , *args)
}