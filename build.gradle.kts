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

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "dev.tonimatas.myfriendlyrobot.Main",
        )
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}