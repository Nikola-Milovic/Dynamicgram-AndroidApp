import com.android.build.gradle.internal.dsl.BaseFlavor
import com.android.build.gradle.internal.dsl.DefaultConfig

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.SAFE_ARGS)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }
    }
    dynamicFeatures = mutableSetOf(":feature_explore", ":feature_messages")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(LibraryDependency.PLAY_CORE)
    implementation(project(":feature_homefeed"))

    api(LibraryDependency.ANDROID_LEGACY_SUPPORT)
    api(LibraryDependency.LIFECYCLE_EXTENSIONS)
    api(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)

    api(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_UI_KTX)
    api(LibraryDependency.RECYCLER_VIEW)
    api(LibraryDependency.MATERIAL)
    api(LibraryDependency.FRAGMENT_KTX)
    api(LibraryDependency.SUPPORT_CONSTRAINT_LAYOUT)
    api(LibraryDependency.NAVIGATION_DYNAMIC_FEATURES)
    api(LibraryDependency.TIMBER)
}


val bundletoolJar = project.rootDir.resolve("third_party/bundletool/bundletool-all-0.13.0.jar")

android.applicationVariants.all(object : Action<com.android.build.gradle.api.ApplicationVariant> {
    override fun execute(variant: com.android.build.gradle.api.ApplicationVariant) {
        variant.outputs.forEach { output: com.android.build.gradle.api.BaseVariantOutput? ->
            (output as? com.android.build.gradle.api.ApkVariantOutput)?.let { apkOutput: com.android.build.gradle.api.ApkVariantOutput ->
                var filePath = apkOutput.outputFile.absolutePath
                filePath = filePath.replaceAfterLast(".", "aab")
                filePath = filePath.replace("build/outputs/apk/", "build/outputs/bundle/")
                var outputPath = filePath.replace("build/outputs/bundle/", "build/outputs/apks/")
                outputPath = outputPath.replaceAfterLast(".", "apks")

                tasks.register<JavaExec>("buildApks${variant.name.capitalize()}") {
                    classpath = files(bundletoolJar)
                    args = listOf(
                        "build-apks",
                        "--overwrite",
                        "--local-testing",
                        "--bundle",
                        filePath,
                        "--output",
                        outputPath
                    )
                    dependsOn("bundle${variant.name.capitalize()}")
                }

                tasks.register<JavaExec>("installApkSplitsForTest${variant.name.capitalize()}") {
                    classpath = files(bundletoolJar)
                    args = listOf("install-apks", "--apks", outputPath)
                    dependsOn("buildApks${variant.name.capitalize()}")
                }

            }
        }
    }
})
