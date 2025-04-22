plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":core"))
    implementation(libs.grpcKotlinStub)

    runtimeOnly(libs.kotlinReflect)

    testImplementation(kotlin("test"))
    testImplementation(libs.grpcTesting)
}

application {
    mainClass = "com.ideascale.app.MainKt"
}
