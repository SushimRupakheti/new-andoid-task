plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdkVersion(35) // Updated to the latest API Level 35

    buildFeatures {
        viewBinding = true
    }

    namespace = "com.example.task_app"

    defaultConfig {
        applicationId = "com.example.task_app"
        minSdk = 24
        targetSdk = 35 // Targeting the latest API Level 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // Ensure the latest version supports API 35
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("androidx.recyclerview:recyclerview:1.3.1") // Latest stable RecyclerView
    implementation("androidx.core:core:1.15.0") // Ensure compatibility with API Level 35
    implementation("androidx.core:core-ktx:1.15.0") // Ensure compatibility with API Level 35

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
