package ru.alxdv.testingserver.service

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.alxdv.testingserver.model.*
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class TestCoroutineService {

    private val testUserDTO = TestUserDTO("testUsername", "testPassword")

    @Value("\${servers.urls.blocking}")
    lateinit var blockingServerURL: String

    @Value("\${servers.urls.reactive}")
    lateinit var reactiveServerURL: String

    @OptIn(FlowPreview::class, DelicateCoroutinesApi::class)
    suspend fun testServer(testRequest: TestRequest): TestResponse {
        val webClient = when (testRequest.serverType) {
            ServerType.BLOCKING -> WebClient.builder().baseUrl(blockingServerURL).build()
            ServerType.REACTIVE -> WebClient.builder().baseUrl(reactiveServerURL).build()
        }

        val users = Collections.nCopies(testRequest.requestAmount, testUserDTO)

        val timeBeforeTest = LocalDateTime.now()

//        val result = users.pmap { performRequest(webClient, it) } fails when >1000 elements

        val result = users.asFlow().flatMapMerge(
            if (testRequest.requestAmount > 1000) 1000 else testRequest.requestAmount
        ) { flowOf(performRequest(webClient, it)) }.launchIn(GlobalScope) // very slow

        val timeAfterTest = LocalDateTime.now()

        return TestResponse(
            serverType = testRequest.serverType,
            requestAmount = testRequest.requestAmount,
            duration = ChronoUnit.MILLIS.between(timeBeforeTest, timeAfterTest)
        )

    }



    suspend fun performRequest(webClient: WebClient, testUserDTO: TestUserDTO) = coroutineScope {
        withContext(Dispatchers.Default) {
            webClient.post()
                .uri("/users")
                .bodyValue(testUserDTO)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<TestUser>()
        }
    }



    suspend fun <A, B> Iterable<A>.pmap(f: suspend (A) -> B): List<B> = coroutineScope {
        map { async { f(it) } }.awaitAll()
    }
}