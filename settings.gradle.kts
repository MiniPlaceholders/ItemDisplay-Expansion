enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ItemDisplay-Expansion"

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://central.sonatype.com/repository/maven-snapshots/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

arrayOf("common", "paper", "sponge").forEach {
    include("itemdisplay-expansion-$it")

    project(":itemdisplay-expansion-$it").projectDir = file(it)
}

