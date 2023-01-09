// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.diffplug.spotless") version "5.3.0"
    id ("com.android.application") version "7.2.2" apply false
    id ("com.android.library") version "7.2.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
}
buildscript {
    repositories {
        google()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.2.2")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0-alpha04")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44.2")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}


apply(plugin = "com.diffplug.spotless")
spotless {
    kotlin {
        target("**/*.kt")
        licenseHeaderFile(
            rootProject.file("${project.rootDir}/spotless/LICENSE.txt"),
            "^(package|object|import|interface)"
        )
    }
}