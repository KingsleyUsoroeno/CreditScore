import Dependencies.AndroidX
import Dependencies.Config
import Dependencies.Coroutines
import Dependencies.DI
import Dependencies.Network
import Dependencies.Test
import Dependencies.View

plugins {
    androidApplication
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {

    defaultConfig {
        applicationId(Config.Android.applicationId)
        minSdkVersion(Config.Version.minSdkVersion)
        compileSdkVersion(Config.Version.compileSdkVersion)
        targetSdkVersion(Config.Version.targetSdkVersion)
        versionCode = Config.Version.versionCode
        versionName = Config.Version.versionName
        multiDexEnabled = Config.isMultiDexEnabled
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/metadata.jvm.kotlin_module")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/**")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }

    buildFeatures.viewBinding = true

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementAll(AndroidX.components)

    implementAll(Network.components)
    implementAll(Coroutines.components)

    implementAll(View.components)

    implementation(DI.daggerHiltAndroid)
    kapt(DI.daggerHiltkapt)

    testImplementation(Test.runner)
    testImplementation(Test.androidXTest)
    testImplementation(Test.junit)
    testImplementation(Test.truth)
    testImplementation(Test.androidXTestCore)
    testImplementation(Test.coroutinesTest)
    testImplementation(Test.robolectric)
}