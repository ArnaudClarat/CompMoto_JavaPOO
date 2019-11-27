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
    implementation(group = "org.apache.commons", name = "commons-lang3", version = "3.0")

}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_13
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

application {
    //Configuration de l’application. Utile pour la tâche "run"
    mainClassName = "com.github.ArnaudClarat.CompMoto.app.MainApp" //à remplacer!
}
