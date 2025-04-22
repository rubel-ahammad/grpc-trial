plugins {
    id("com.google.protobuf") version "0.9.4" apply false
}

allprojects {
    group = "com.ideascale"
    version = "1.0-SNAPSHOT"
}

subprojects {
    repositories {
        mavenCentral()
    }
}
