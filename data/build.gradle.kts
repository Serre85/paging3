@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")
}


android {
    namespace = "com.hslee.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation (project(":domain"))

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.46")
    implementation ("androidx.paging:paging-common-ktx:3.1.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.46")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    kapt ("com.google.dagger:dagger-compiler:2.46")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

    // okhttp3
    implementation ("com.squareup.okhttp3:okhttp:4.2.2")
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.2.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.2.2")
}