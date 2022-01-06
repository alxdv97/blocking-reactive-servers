package ru.alxdv.testingserver.model

data class TestResponse(val serverType: ServerType, val requestAmount: Int, val duration: Long)
