package ru.alxdv.testingserver.controller

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import ru.alxdv.testingserver.model.ServerType
import ru.alxdv.testingserver.model.TestRequest
import ru.alxdv.testingserver.model.TestResponse
import ru.alxdv.testingserver.service.TestCoroutineService
import ru.alxdv.testingserver.service.TestReactorService

@RestController
@RequestMapping("/test")
class TestController(
    private val testReactorService: TestReactorService,
    private val testCoroutineService: TestCoroutineService
) {

    @GetMapping
    fun testServer(@RequestParam serverType: String, @RequestParam requestAmount: Int): Mono<TestResponse> {
        return testReactorService.testServer(TestRequest(ServerType.valueOf(serverType), requestAmount))
    }

    @GetMapping("/coroutine")
    suspend fun testServerSuspendable(@RequestParam serverType: String, @RequestParam requestAmount: Int): TestResponse {
        return testCoroutineService.testServer(TestRequest(ServerType.valueOf(serverType), requestAmount))
    }
}