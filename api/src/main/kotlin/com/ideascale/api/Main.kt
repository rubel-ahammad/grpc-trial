package com.ideascale.api

import io.grpc.Server
import io.grpc.ServerBuilder

fun main() {
    val server: Server = ServerBuilder
        .forPort(50051)
        .addService(HelloServiceImpl())
        .build()

    server.start()
    println("gRPC Server started on port 50051")
    server.awaitTermination()
}