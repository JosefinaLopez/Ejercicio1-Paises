plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.ejercicio1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ejercicio1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    }
}

dependencies {

    //Implementacion de APis
    implementation ("com.github.kittinunf.fuel:fuel:2.3.1") //Core package"
    implementation ("com.github.kittinunf.fuel:fuel-android:2.3.1") //Android
    implementation ("com.github.kittinunf.fuel:fuel-gson:2.3.1") //Fuel Gson
    implementation ("com.google.code.gson:gson:2.10") //Gson
    implementation ("com.github.kittinunf.fuel:fuel-coroutines:2.3.1")
    implementation("io.coil-kt:coil:2.6.0")
    implementation ("com.squareup.picasso:picasso:2.71828")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}