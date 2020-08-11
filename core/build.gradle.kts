plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

}
dependencies {
    api(LibraryDependency.TIMBER)

    api(LibraryDependency.ANDROID_LEGACY_SUPPORT)
    api(LibraryDependency.LIFECYCLE_EXTENSIONS)
    api(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)

    //Dagger
    api(LibraryDependency.DAGGER)
    kapt(LibraryDependency.DAGGER_COMPILE)
    api(LibraryDependency.DAGGER_ANDROID)
    api(LibraryDependency.DAGGER_ANDROID_SUPPORT)
    kapt(LibraryDependency.DAGGER_ANDROID_PROCESSOR)


    api(LibraryDependency.GLIDE)
    kapt(LibraryDependency.GLIDE_AP)

    implementation(LibraryDependency.RECYCLER_VIEW)
    //circular image view
    implementation("de.hdodenhof:circleimageview:3.1.0")

    addTestDependencies()

}
