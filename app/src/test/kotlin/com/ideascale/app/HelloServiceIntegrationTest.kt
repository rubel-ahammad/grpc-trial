package com.ideascale.app

import com.ideascale.core.Hello.HelloRequest
import com.ideascale.core.Hello.HelloResponse
import com.ideascale.core.HelloServiceGrpcKt
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Server
import io.grpc.ServerBuilder
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Integration test for the HelloService.
 * This test starts a real gRPC server with a mock implementation and connects to it with a client.
 */
class HelloServiceIntegrationTest {

    private lateinit var server: Server
    private lateinit var channel: ManagedChannel

    private val port = 50052 // Using a different port than the main application to avoid conflicts

    /**
     * Mock implementation of the HelloService for testing.
     */
    private class MockHelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
        override suspend fun sayHello(request: HelloRequest): HelloResponse {
            val message = "Hello, ${request.name}!"
            return HelloResponse.newBuilder().setMessage(message).build()
        }
    }

    @BeforeEach
    fun setup() {
        // Start the server with our mock service
        server = ServerBuilder.forPort(port)
            .addService(MockHelloService())
            .build()
            .start()
        println("Test server started on port $port")

        // Create a channel to the server
        channel = ManagedChannelBuilder.forAddress("localhost", port)
            .usePlaintext()
            .build()
    }

    @AfterEach
    fun teardown() {
        // Shutdown the channel and server
        channel.shutdown()
        server.shutdown()
        println("Test server and channel shut down")
    }

    @Test
    fun `test end-to-end communication`() = runBlocking {
        // Arrange
        val stub = HelloServiceGrpcKt.HelloServiceCoroutineStub(channel)
        val name = "Integration Test"
        val request = HelloRequest.newBuilder().setName(name).build()

        // Act
        val response = stub.sayHello(request)

        // Assert
        assertEquals("Hello, $name!", response.message)
    }
}
