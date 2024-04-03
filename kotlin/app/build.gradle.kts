plugins {
    alias(libs.plugins.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("aws.sdk.kotlin:sesv2:1.0.30")
    implementation("aws.smithy.kotlin:http-client-engine-okhttp:0.30.0")
    implementation("aws.smithy.kotlin:http-client-engine-crt:0.30.0")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.AppKt"
}
