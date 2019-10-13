plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinAndroidExtension)
    kotlin(Plugins.kotlinKapt)
}

val javaVersion: JavaVersion by extra { JavaVersion.VERSION_1_8 }

android {
    compileSdkVersion(extra["compileSdkVersion"] as Int)
    defaultConfig {
        applicationId = "com.github.nuhkoca.kotlinscarletwebsocket"
        minSdkVersion(extra["minSdkVersion"] as Int)
        targetSdkVersion(extra["targetSdkVersion"] as Int)
        versionCode = 1
        versionName = getSemVer()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    packagingOptions {
        pickFirst("mockito-extensins/org.mockito.plugins.MockMaker")
        exclude("META-INF/io.netty.versions.properties")
        exclude("META-INF/INDEX.LIST")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    androidExtensions {
        isExperimental = true
    }

    lintOptions {
        isAbortOnError = false
        isWarningsAsErrors = true
        isCheckDependencies = true
        isIgnoreTestSources = true
        setLintConfig(file("lint.xml"))
        disable("GradleDeprecated")
        disable("OldTargetApi")
        disable("GradleDependency")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(project(Modules.core))
    api(project(Modules.data))
    api(project(Modules.domain))

    api(Dependencies.kotlin)
    implementation(Dependencies.material)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.constraint_layout)

    implementation(Dependencies.rx_kotlin)

    api(Dependencies.lifecycle_extensions)
    implementation(Dependencies.lifecycle_runtime)
    kapt(Dependencies.lifecycle_compiler)
    implementation(Dependencies.lifecycle_viewmodel)

    implementation(Dependencies.dagger)
    implementation(Dependencies.dagger_android)
    api(Dependencies.dagger_android_support)
    kapt(Dependencies.dagger_android_processor)
    kapt(Dependencies.dagger_compiler)
    compileOnly(Dependencies.javax_annotation)

    api(Dependencies.scarlet)
    api(Dependencies.scarlet_websocket)
    api(Dependencies.scarlet_moshi)

    api(Dependencies.timber_kt)

    testImplementation(TestDependencies.test_core)
    testImplementation(TestDependencies.arch_core)
    testImplementation(TestDependencies.rules)
    testImplementation(TestDependencies.runner)
    testImplementation(TestDependencies.truth)
    testImplementation(TestDependencies.truth_ext)
    testImplementation(TestDependencies.mockito)

    androidTestImplementation(TestDependencies.junit)
    androidTestImplementation(TestDependencies.espresso_core)
}

fun getSemVer(): String {
    val majorCode = 1
    val minorCode = 0
    val patchCode = 0

    return "$majorCode.$minorCode.$patchCode"
}
