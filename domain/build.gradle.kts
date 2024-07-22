@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")
}


android {
    namespace = "com.hslee.domain"
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    //Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    implementation ("androidx.paging:paging-common-ktx:3.1.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    kapt ("com.google.dagger:dagger-compiler:2.44")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
}