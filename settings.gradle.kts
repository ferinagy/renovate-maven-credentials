/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.8/userguide/multi_project_builds.html in the Gradle documentation.
 */

rootProject.name = "renovate-maven-credentials"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.pkg.github.com/org/repo/") {
            credentials {
                username = "username"
                password = "password"
            }
        }
    }
}

include(":app")
