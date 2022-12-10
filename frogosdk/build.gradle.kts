import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK
    namespace = ProjectSetting.PROJECT_LIB_ID_SDK

    defaultConfig {
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    api(project(DependencyGradle.FROGO_PATH_CORE_SDK))
    api(project(DependencyGradle.FROGO_PATH_LOG))

    api(Androidx.appCompat)
    api(Androidx.appCompatResources)

    api(Androidx.activityKtx)
    api(Androidx.fragmentKtx)

    api(Androidx.constraintLayout)
    api(Androidx.collection)
    api(Androidx.savedState)
    api(Androidx.viewPager2)
    api(Androidx.preferenceKtx)
    api(Androidx.annotation)

    api(Androidx.Core.ktx)

    api(Androidx.Lifecycle.runtimeKtx)
    api(Androidx.Lifecycle.viewmodelKtx)
    api(Androidx.Lifecycle.livedataKtx)

    api(Androidx.Room.ktx)
    api(Androidx.Room.runtime)
    api(Androidx.Room.rxJava3)

    api(Google.material)
    api(Google.gson)

    api(Square.OkHttp.okhttp)
    api(Square.OkHttp.loggingInterceptor)

    api(Square.Retrofit2.retrofit)
    api(Square.Retrofit2.converterGson)
    api(Square.Retrofit2.adapterRxJava3)

    api(Reactivex.rxJava3)
    api(Reactivex.rxAndroid3)

    api(Koin.core)
    api(Koin.android)
    api(Koin.androidCompat)
    api(Koin.androidxWorkManager)

    api(GitHub.chucker)
    api(GitHub.glide)

    api(GitHub.piracyChecker)
    api(GitHub.customActivityOnCrash)

    api(JetBrains.coroutinesCore)
    api(JetBrains.coroutinesAndroid)

    kapt(Androidx.Lifecycle.compiler)
    kapt(Androidx.Room.compiler)
    kapt(GitHub.glideCompiler)

}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.PROJECT_LIB_ID_SDK

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.MODULE_NAME_SDK

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}