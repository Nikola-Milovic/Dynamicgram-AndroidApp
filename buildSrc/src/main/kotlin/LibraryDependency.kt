@file:Suppress("detekt.StringLiteralDuplication")

private object LibraryVersion {
    const val TIMBER = "4.7.1"
    const val PLAY_CORE = "1.7.3" //164
    const val APP_COMPACT = "1.1.0"
    const val RECYCLER_VIEW = "1.1.0"
    const val COORDINATOR_LAYOUT = "1.1.0"

    // 1.1.x version is required in order to support the dark theme functionality in
    // Android Q(adds Theme.MaterialComponents.DayNight)
    const val MATERIAL = "1.1.0-alpha09"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val CORE_KTX = "1.1.0"
    const val FRAGMENT_KTX = "1.1.0"
    const val LIFECYCLE = "1.1.1"
    const val LIFECYCLE_VIEW_MODEL_KTX = "2.1.0"
}

object LibraryDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"

    // Required by Android dynamic feature modules and SafeArgs
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${CoreVersion.KOTLIN}"

    const val TIMBER = "com.jakewharton.timber:timber:${LibraryVersion.TIMBER}"
    const val SUPPORT_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val PLAY_CORE = "com.google.android.play:core:${LibraryVersion.PLAY_CORE}"
    const val APP_COMPACT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}"
    const val COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:${LibraryVersion.COORDINATOR_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersion.COROUTINES_ANDROID}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${LibraryVersion.FRAGMENT_KTX}"
    const val LIFECYCLE_EXTENSIONS = "android.arch.lifecycle:extensions:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.LIFECYCLE_VIEW_MODEL_KTX}"
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURES = "androidx.navigation:navigation-dynamic-features-fragment:${CoreVersion.NAVIGATION}"
}
