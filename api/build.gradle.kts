plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")
    // Apply Kotlin Serialization plugin from `gradle/libs.versions.toml`.
    alias(libs.plugins.kotlinPluginSerialization)
    application
}

dependencies {
    implementation(project(":core"))
    // Only include the gRPC dependencies that are directly used by the api module
    implementation("io.grpc:grpc-netty-shaded:1.63.0") // For Server and ServerBuilder
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")

    // Apply the kotlinx bundle of dependencies from the version catalog (`gradle/libs.versions.toml`).
    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}
