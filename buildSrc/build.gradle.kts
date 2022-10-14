plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        create("GradlePluginConfig") {
            id = "GradlePluginConfig"
            implementationClass = "GradlePluginConfig"
        }
    }
}