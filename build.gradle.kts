plugins {
    java
    id("com.gradleup.shadow") version "9.3.1"
}

group = "dev.tonimatas.myfriendlyrobot"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.kwhat:jnativehook:2.2.2")
    implementation("net.java.dev.jna:jna:5.18.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    
    
    dependsOn("shadowJar")
    archiveClassifier.set("plain")
}

tasks.shadowJar {
    archiveClassifier.set("")

    manifest {
        attributes(
            "Main-Class" to "dev.tonimatas.myfriendlyrobot.Main",
        )
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}