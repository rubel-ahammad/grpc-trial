plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")

//    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("com.google.protobuf") version "0.9.4"
}

dependencies {
    api("io.grpc:grpc-netty-shaded:1.63.0")
    api("io.grpc:grpc-protobuf:1.63.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.grpc:grpc-stub:1.63.0")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.63.0"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.0:jdk8@jar"
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
