package com.gonzo.ktapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtapiApplication

fun main(args: Array<String>) {
    runApplication<KtapiApplication>(*args)
}
