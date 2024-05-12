import io.izzel.taboolib.gradle.*

plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.izzel.taboolib") version "2.0.11"
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
    id("org.jetbrains.dokka") version "1.9.20"
    id("io.codearte.nexus-staging") version "0.30.0"
}


val order: String? by project
val api: String? by project
task("api-add") {
    var version = project.version.toString() + (order?.let { "-$it" } ?: "")
    if (api != null && api == "common")
        version = "$version-api"
    project.version = version
}
task("info") {
    println(project.name + "-" + project.version)
    println(project.version.toString())
}
taboolib {
    description {
        contributors {
            name("Clok")
        }
        dependencies {
            name("Pouvoir")
            name("UnrealCore")
        }
    }
    env{
        install(CONFIGURATION, LANG, BUKKIT, METRICS, CHAT, BUKKIT_ALL)
    }
    classifier = null
    version {
        if(project.gradle.startParameter.taskNames.getOrNull(0) == "taboolibBuildApi" || api != null){
            println("api!")
            isSkipKotlinRelocate =true
            isSkipKotlin = true
        }
        taboolib = "6.1.1-beta17"
    }
}
repositories {
    mavenCentral()
    maven { url = uri("https://mvn.lumine.io/repository/maven-public/") }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}
dependencies {
    compileOnly("ink.ptms.core:v11800:11800-minimize:mapped")
    compileOnly("ink.ptms.core:v11800:11800-minimize:api")
    compileOnly("com.google.code.gson:gson:2.9.0")
    compileOnly("io.lumine:Mythic-Dist:5.0.3")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.register<Jar>("buildAPIJar") {
    dependsOn(tasks.compileJava, tasks.compileKotlin)
    from(tasks.compileJava, tasks.compileKotlin)
    includeEmptyDirs = false
    include { it.isDirectory or it.name.endsWith(".class") or it.name.endsWith(".kotlin_module") }
    archiveClassifier.set("api")
}

tasks.register<Jar>("buildSourcesJar") {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}
