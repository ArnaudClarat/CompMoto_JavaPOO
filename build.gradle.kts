plugins {
    java
    application
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testCompile("junit", "junit", "4.12")
    implementation(group = "com.h2database", name = "h2", version = "1.4.196")
    implementation(group = "org.fluttercode.datafactory", name = "datafactory", version= "0.8")
    implementation("com.esotericsoftware:minlog:1.3.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}