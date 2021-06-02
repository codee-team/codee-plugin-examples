dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.kotlingang.fun")
    }
}
rootProject.name = "My Application"
include(":examples")
 