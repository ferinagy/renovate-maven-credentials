plugins {
    id("com.android.application")
}

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 34
        targetSdk = 34
    }
    namespace = "com.example.test"
}

dependencies {
    implementation("com.secret.library:confidential:1.0.0")
}