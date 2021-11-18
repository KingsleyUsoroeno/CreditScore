const val kotlinKapt: String = "kapt"
const val kotlinAndroid: String = "android"

object Dependencies {

    interface Libraries {
        val components: List<String>
    }


    object Config {
        object Version {
            const val minSdkVersion: Int = 21
            const val compileSdkVersion: Int = 31
            const val targetSdkVersion: Int = 31
            const val versionName: String = "1.0"
            const val versionCode: Int = 1
        }

        const val isMultiDexEnabled: Boolean = true

        object Android {
            const val applicationId: String = "com.example.creditscore"
        }
    }

    object AndroidX : Libraries {
        private const val coreKtx: String = "androidx.core:core-ktx:${Versions.ktxCore}"
        private const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
        private const val navigationUi =
            "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
        private const val multiDex: String = "androidx.multidex:multidex:${Versions.multidex}"
        override val components: List<String> = listOf(
            coreKtx, navigationFragment, navigationUi, multiDex
        )
    }

    object View : Libraries {
        private const val appCompat: String = "androidx.appcompat:appcompat:${Versions.appCompat}"
        private const val materialComponent: String =
            "com.google.android.material:material:${Versions.material}"
        private const val constraintLayout: String =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        private const val lifecycleLiveData =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"

        override val components: List<String>
            get() = listOf(
                appCompat,
                materialComponent,
                lifecycleLiveData,
                constraintLayout,
            )
    }

    object Coroutines : Libraries {
        private const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        private const val android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

        override val components: List<String> = listOf(core, android)
    }

    object Test {
        const val junit: String = "junit:junit:${Versions.jUnit}"
        const val runner: String = "androidx.test:runner:${Versions.runner}"
        const val androidXTest: String = "androidx.test.ext:junit:${Versions.testExt}"
        const val truth: String = "com.google.truth:truth:${Versions.truth}"
        const val coroutinesTest: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val robolectric: String = "org.robolectric:robolectric:${Versions.robolectric}"
        const val androidXTestCore = "androidx.test:core:${Versions.androidXTestCore}"
    }

    object DI {
        object AnnotationProcessor {
            const val jetpackHiltCompiler: String =
                "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"
        }

        const val javaxInject: String = "javax.inject:javax.inject:${Versions.javaxInject}"
        const val hiltViewModel: String =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
        const val hiltTesting: String =
            "com.google.dagger:hilt-android-testing:${Versions.daggerHiltAndroid}"

        const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHiltAndroid}"
        const val daggerHiltkapt =
            "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltAndroid}"
    }


    object Network : Libraries {
        private const val okhttp: String = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        private const val loggingInterceptor: String =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        private const val retrofitConverter =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

        override val components: List<String> = listOf(
            okhttp,
            loggingInterceptor,
            retrofit,
            retrofitConverter
        )
    }
}