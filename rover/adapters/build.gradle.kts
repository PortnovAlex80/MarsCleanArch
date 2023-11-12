import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

        plugins {
            id("org.springframework.boot") version "3.1.2"
            id("io.spring.dependency-management") version "1.1.2"
            kotlin("jvm") version "1.8.22"
            kotlin("plugin.spring") version "1.8.22"
        }

group = "com.marsrover"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation ("io.arrow-kt:arrow-core:1.0.1")
    // view
    implementation( "org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")

    implementation(project(":rover:domain"))
    implementation(project(":rover:usecases"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


