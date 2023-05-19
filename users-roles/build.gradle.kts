plugins {
    java
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.1.0"
    groovy
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    implementation("org.liquibase:liquibase-core:4.20.0") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }

    // https://mvnrepository.com/artifact/org.yaml/snakeyaml
    implementation("org.yaml:snakeyaml:1.32")

    //liquibase
    implementation("org.liquibase:liquibase-core:4.20.0")



    testImplementation("org.spockframework:spock-core")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //liquibase
    implementation("org.liquibase:liquibase-core:4.20.0")

    runtimeOnly("org.postgresql:postgresql")



    implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

    //swagger-ui
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    testImplementation("io.github.benas:random-beans:3.9.0")

    implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:2.2.0")

    implementation("org.springframework.boot:spring-boot-starter-mail")

    // client
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.1")
    implementation("io.github.openfeign:feign-httpclient:10.12")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    //security
    implementation("org.springframework.security:spring-security-core:6.0.3")
    implementation("org.springframework.boot:spring-boot-starter-security:3.0.6")

    //unit testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.spockframework:spock-spring:2.3-groovy-4.0")
    testImplementation ("io.github.benas:random-beans:3.9.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
