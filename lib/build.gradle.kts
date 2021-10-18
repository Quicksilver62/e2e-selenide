plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.18")
    annotationProcessor("org.projectlombok:lombok:1.18.18")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testImplementation("com.codeborne:selenide:5.25.0")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.0-alpha4")
    implementation("com.browserup:browserup-proxy-core:2.1.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile>{
    options.encoding = "UTF-8"
}

tasks.withType<Test>().configureEach() {
    useJUnitPlatform()
    testLogging.showExceptions = true
}
