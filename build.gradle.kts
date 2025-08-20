plugins {
    java
    alias(libs.plugins.shadow)
}

dependencies {
    compileOnly(libs.miniplaceholders)
    compileOnly(libs.adventure.api)
    compileOnly(libs.adventure.minimessage)
    implementation(projects.itemdisplayExpansionCommon)
    implementation(projects.itemdisplayExpansionPaper)
    implementation(projects.itemdisplayExpansionSponge)
}

allprojects {
    apply<JavaPlugin>()
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(21)
        }
    }
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${project.version}.jar")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
