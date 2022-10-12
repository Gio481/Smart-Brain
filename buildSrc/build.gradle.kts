plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        create("GradleConfigPlugin") {
            id = "GradleConfigPlugin"
            implementationClass = "GradleConfigPlugin"
        }
    }
}