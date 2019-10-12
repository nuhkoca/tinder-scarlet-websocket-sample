object Dependencies {
    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_gradle_plugin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"

    // RxJava
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"

    // Scarlet
    const val scarlet = "com.github.tinder.scarlet:scarlet:${Versions.scarlet}"
    const val scarlet_rxjava =
        "com.github.tinder.scarlet:scarlet-stream-adapter-rxjava2:${Versions.scarlet}"
    const val scarlet_websocket =
        "com.github.tinder.scarlet:scarlet-protocol-websocket-okhttp:${Versions.scarlet}"
    const val scarlet_moshi =
        "com.github.tinder.scarlet:scarlet-message-adapter-moshi:${Versions.scarlet}"
    const val scarlet_lifecycle =
        "com.github.tinder.scarlet:scarlet-lifecycle-android:${Versions.scarlet}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val dagger_android_processor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val javax_annotation = "org.glassfish:javax.annotation:${Versions.javax}"
}

object TestDependencies {
    // Core library
    const val test_core = "androidx.test:core:${Versions.test_core}"
    const val arch_core = "android.arch.core:core-testing:${Versions.arch_core}"

    // AndroidJUnitRunner and JUnit Rules
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val rules = "androidx.test:rules:${Versions.rules}"

    // Assertions
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val truth_ext = "androidx.test.ext:truth:${Versions.truth_ext}"
    const val truth = "com.google.truth:truth:${Versions.truth}"

    // Espresso
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    // Mockito
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
}
