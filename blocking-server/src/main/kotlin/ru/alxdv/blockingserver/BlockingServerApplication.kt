package ru.alxdv.blockingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlockingServerApplication

fun main(args: Array<String>) {
    runApplication<BlockingServerApplication>(*args)
}
