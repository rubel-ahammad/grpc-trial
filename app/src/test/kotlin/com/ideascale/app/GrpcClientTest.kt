package com.ideascale.app

import com.ideascale.core.Hello.HelloRequest
import com.ideascale.core.Hello.HelloResponse
import com.ideascale.core.HelloServiceGrpcKt
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GrpcClientTest {

    @Test
    fun `test HelloRequest structure`() {
        val name = "Test Client"
        val request = HelloRequest.newBuilder().setName(name).build()

        assertEquals(name, request.name)
    }

    @Test
    fun `test HelloResponse structure`() {
        val message = "Hello, Test Client!"
        val response = HelloResponse.newBuilder().setMessage(message).build()

        assertEquals(message, response.message)
    }

    @Test
    fun `test channel creation`() {
        val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build()

        assertNotNull(channel)

        channel.shutdown()
    }

    @Test
    fun `test stub creation`() {
        val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build()

        val stub = HelloServiceGrpcKt.HelloServiceCoroutineStub(channel)

        assertNotNull(stub)

        channel.shutdown()
    }
}
