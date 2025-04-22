package com.ideascale.api

import com.ideascale.core.Hello.HelloRequest
import com.ideascale.core.Hello.HelloResponse
import com.ideascale.core.HelloServiceGrpcKt

class HelloServiceImpl : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloResponse {
        val message = "Hello, ${request.name}!"
        return HelloResponse.newBuilder().setMessage(message).build()
    }
}