plugins {
    java
}

group = "dev.tonimatas.myfriendlyrobot"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "dev.tonimatas.myfriendlyrobot.Main",
        )
    }
}