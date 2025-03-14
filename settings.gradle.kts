pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Assessment"
include(":app")
include(":app:featuredata")
include(":app:featureModel")
include(":featueassessmentdata")
include(":feature:assesment:data")
include(":feature:assesment:domain")
include(":feature:assesment:ui")
include(":feature:details")
include(":feature:featuredetails:data")
include(":feature:featuredetails:domain")
include(":feature:featuredetails:ui")
include(":core:network")
include(":core:common")
include(":core:feature_api")
