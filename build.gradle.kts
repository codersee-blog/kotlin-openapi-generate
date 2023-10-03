plugins {
    kotlin("jvm") version "1.9.10"
    application
    id("org.openapi.generator") version "7.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileKotlin{
    dependsOn("openApiGenerate")
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

openApiGenerate {
    inputSpec.set("$rootDir/openapi/json-placeholder-api.yaml")
    generatorName.set("kotlin")
}

sourceSets {
    main {
        java {
            srcDir("${buildDir}/generate-resources/main/src")
        }
    }
}
