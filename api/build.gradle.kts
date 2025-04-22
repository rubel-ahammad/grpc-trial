plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
    application
}

dependencies {
    implementation(project(":core"))
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")

    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}
