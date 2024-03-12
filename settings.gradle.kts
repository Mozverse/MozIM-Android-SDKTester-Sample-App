pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
//        maven {
//            setUrl("https://jitpack.io")
//            credentials { username = providers.gradleProperty("MOZIM_JITPACK_TOKEN").get() }
//            // in case of error add next line to $HOME/.gradle/gradle.properties in format
//            // MOZIM_JITPACK_TOKEN=<YOUR_JITPACK_TOKEN>
//        }
    }
}

rootProject.name = "MozimTestApp"
include(":app")
 