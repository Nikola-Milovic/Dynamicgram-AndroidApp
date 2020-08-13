plugins {
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    kotlin("android")
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android.txt", "proguard-rules.pro", "proguard-rules-dynamic-features.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":app"))
    testImplementation(TestLibraryDependency.JUNIT)

    //Dagger
    api(LibraryDependency.DAGGER)
    kapt(LibraryDependency.DAGGER_COMPILE)
    api(LibraryDependency.DAGGER_ANDROID)
    api(LibraryDependency.DAGGER_ANDROID_SUPPORT)
    kapt(LibraryDependency.DAGGER_ANDROID_PROCESSOR)
}
