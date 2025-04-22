package com.ideascale.app

import com.ideascale.core.Hello.HelloRequest
import com.ideascale.core.HelloServiceGrpcKt
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val stub = HelloServiceGrpcKt.HelloServiceCoroutineStub(channel)

    val request = HelloRequest.newBuilder().setName("Kotlin Developer").build()
    val response = stub.sayHello(request)
    println("Received from server: ${response.message}")

    channel.shutdown()
}
