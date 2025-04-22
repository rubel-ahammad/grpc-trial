plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.protobuf)
}

dependencies {
    api(libs.grpcNetty)
    api(libs.grpcProtobuf)
    api(libs.kotlinxCoroutines)

    implementation(libs.grpcKotlinStub)
    implementation(libs.grpcStub)

    runtimeOnly(libs.kotlinReflect)
}

protobuf {
    protoc {
        artifact = libs.protoc.get().toString()
    }
    plugins {
        create("grpc") {
            artifact = libs.protocGenGrpcJava.get().toString()
        }
        create("grpckt") {
            artifact = "${libs.protocGenGrpcKotlin.get()}:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
        }
    }
}
