package ru.alxdv.testingserver.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.alxdv.testingserver.model.ServerType
import ru.alxdv.testingserver.model.TestRequest
import ru.alxdv.testingserver.model.TestResponse
import ru.alxdv.testingserver.model.TestUserDTO
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class TestReactorService {


    private val testUserDTO = TestUserDTO("testUsername", "testPassword")

    fun testServer(testRequest: TestRequest): Mono<TestResponse> {

        val webClient = when (testRequest.serverType) {
            ServerType.BLOCKING -> WebClient.builder().baseUrl("http://localhost:8080/blocking").build()
            ServerType.REACTIVE -> WebClient.builder().baseUrl("http://localhost:8081/reactive").build()
        }

        val users = Collections.nCopies(testRequest.requestAmount, testUserDTO)

        val timeBeforeTest = LocalDateTime.now()

//        Flux.fromIterable(users).flatMap({ u: TestUser ->
//            performRequest(
//                webClient,
//                u
//            )
//        }, 1000).subscribe { x: Void? -> println(x) }
        val result = Flux
            .fromIterable(users)
            .flatMap(
                { performRequest(webClient, it) },
                if (testRequest.requestAmount > 1000) 1000 else testRequest.requestAmount
            )
            .subscribe(System.out::println)

//        TODO how to await all results?

        val timeAfterTest = LocalDateTime.now()

        val testResponse = TestResponse(
            serverType = testRequest.serverType,
            requestAmount = testRequest.requestAmount,
            duration = ChronoUnit.MILLIS.between(timeBeforeTest, timeAfterTest)
        )

        return Mono.just(testResponse)
    }

    fun performRequest(webClient: WebClient, testUserDTO: TestUserDTO): Mono<Void> {
        return webClient.post()
            .uri("/users")
            .bodyValue(testUserDTO)
            .retrieve()
            .bodyToMono(Void::class.java)
    }

}