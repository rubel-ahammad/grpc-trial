plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":core"))
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation(kotlin("test"))
    testImplementation("io.grpc:grpc-testing:1.63.0")
}

application {
    mainClass = "com.ideascale.app.MainKt"
}
