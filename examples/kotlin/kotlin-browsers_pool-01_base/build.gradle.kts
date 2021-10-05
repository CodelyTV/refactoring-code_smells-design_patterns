import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    id("com.diffplug.spotless") version "5.7.0"
    application
}

group = "com.codely"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.15.0")

    implementation("org.seleniumhq.selenium:selenium-firefox-driver:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
application {
    mainClass.set("com.codely.demo.CodelyberKt")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    kotlin {
        ktlint()
            .userData(
                mapOf(
                    "insert_final_newline" to "true"
                )
            )
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
}

tasks.test {
    useJUnitPlatform()
    maxParallelForks = 1
    testLogging {
        events("passed", "skipped", "failed")
    }
}
