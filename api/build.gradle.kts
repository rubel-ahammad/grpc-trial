plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
    application
}

dependencies {
    implementation(project(":core"))
    implementation(libs.grpcKotlinStub)

    runtimeOnly(libs.kotlinReflect)

    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}
