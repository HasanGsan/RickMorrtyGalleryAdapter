plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.test_solo_project_h"
    compileSdk = 34




    defaultConfig {
        applicationId = "com.example.test_solo_project_h"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }



    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit2.adapter.rxjava2)
    implementation(libs.converter.moshi)

    //Retrofit GSON CONVERTER
    implementation (libs.converter.gson)

    // Kotlin Serialization
    implementation(libs.jetbrains.kotlinx.serialization.json)

    // RxJava
    implementation(libs.rxjava)
    implementation(libs.rxandroid)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // AndroidX Libraries
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.material)
    implementation(libs.androidx.navigation.ui.ktx)

    // Glide
    implementation(libs.github.glide)

    //serialization
    implementation (libs.retrofit2.kotlinx.serialization.converter)

    implementation (libs.androidx.ui)
    implementation (libs.androidx.material)
    implementation (libs.androidx.ui.tooling)
    implementation(libs.androidx.junit.ktx)
    androidTestImplementation(libs.junit.junit)


    //dagger
    implementation (libs.dagger)
    implementation (libs.javax.annotation.api)




    //load image Glide / Coil

    implementation (libs.coil)
    implementation (libs.github.glide)

    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)


}
