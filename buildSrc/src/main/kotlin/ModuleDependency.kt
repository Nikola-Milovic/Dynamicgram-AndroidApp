

private const val FEATURE_PREFIX = ":feature_"

// "Module" means "project" in terminology of Gradle API. To be specific each "Android module" is a Gradle "subproject"
@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"
}
