plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 21
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("me.neon.codee:core:1.0.1")
    implementation(kotlin("reflect"))
    implementation(kotlin("script-util"))
    implementation(kotlin("scripting-compiler-embeddable"))
    implementation(
        group = "org.jetbrains.kotlin",
        name = "kotlin-scripting-dependencies",
        version = "1.4.32"
    )
}