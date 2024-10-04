plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
    //mockito  --> objetos instanciados
    testImplementation ("org.mockito:mockito-core:5.14.1")
    testImplementation ("org.mockito:mockito-junit-jupiter:5.14.1")

    //objetos estaticos
    testImplementation ("org.mockito:mockito-inline:5.2.0")
}

tasks.test {
    useJUnitPlatform()
}