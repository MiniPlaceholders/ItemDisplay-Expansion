enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ItemDisplay-Expansion"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

arrayOf("paper", "sponge").forEach {
    include("itemdisplay-expansion-$it")

    project(":itemdisplay-expansion-$it").projectDir = file(it)
}

