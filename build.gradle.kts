
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_ersion: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // di
    implementation("io.insert-koin:koin-core:$koin_ersion")
    implementation("io.insert-koin:koin-ktor:3.5.2-RC1")
    implementation("io.insert-koin:koin-logger-slf4j:3.5.1")
    testImplementation("io.insert-koin:koin-test:$koin_ersion") {
        // https://github.com/InsertKoinIO/koin/issues/1526
        exclude("org.jetbrains.kotlin", "kotlin-test-junit")
    }
}
