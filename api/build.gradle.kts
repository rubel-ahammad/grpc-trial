plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
    application
}

dependencies {
    implementation(project(":core"))
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.grpc:grpc-netty-shaded:1.63.0")
    implementation("io.grpc:grpc-protobuf:1.63.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")

    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}
