package com.ideascale.api

import com.ideascale.core.Hello.HelloRequest
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloServiceEndpointTest {

    @Test
    fun `test sayHello returns correct greeting`() = runBlocking {
        val endpoint = HelloServiceEndpoint()
        val name = "Test User"
        val request = HelloRequest.newBuilder().setName(name).build()

        val response = endpoint.sayHello(request)

        assertEquals("Hello, $name!", response.message)
    }

    @Test
    fun `test sayHello with empty name`() = runBlocking {
        val endpoint = HelloServiceEndpoint()
        val request = HelloRequest.newBuilder().setName("").build()

        val response = endpoint.sayHello(request)

        assertEquals("Hello, !", response.message)
    }
}
