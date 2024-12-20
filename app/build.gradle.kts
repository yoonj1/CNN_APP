plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.vgg19"
    compileSdk = 34
    aaptOptions {
        noCompress("tflite") // "tflite" 파일 형식 압축 방지
    }
    defaultConfig {
        applicationId = "com.example.vgg19"
        minSdk = 27
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
}

dependencies {
    // AndroidX libraries
    implementation ("org.tensorflow:tensorflow-lite-select-tf-ops:2.13.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("org.tensorflow:tensorflow-lite:latest_version")
    // AppSearch dependency (최신 버전 유지)
    implementation("androidx.appsearch:appsearch:1.1.0-alpha01")
    implementation("androidx.appsearch:appsearch-local-storage:1.1.0-alpha01")

    // Google Play Services
    implementation("com.google.android.gms:play-services-base:18.0.1")

    // TensorFlow Lite for machine learning (2.11.0 or latest)
    implementation("org.tensorflow:tensorflow-lite:2.13.0")

    // JTransforms for FFT (if needed for audio processing)
    implementation("com.github.wendykierp:JTransforms:3.1")

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
