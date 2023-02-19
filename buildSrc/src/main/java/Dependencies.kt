object Version {
    const val coroutineCore = "1.5.2"
    const val koin = "3.2.0"
    const val room = "2.4.2"
    const val lifecycle = "2.4.1"
    const val lifecycleExtension = "2.2.0"
    const val junit = "4.13.2"
    const val testRunner = "1.1.3"
    const val espresso = "3.4.0"
    const val datastore = "1.0.0"
    const val kotlin = "1.7.0"
}

object Lifecycle {
    const val  ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val  Extension =  "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleExtension}"
    const val  LiveData =  "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
}

object Libraries {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val Koin = "io.insert-koin:koin-android:${Version.koin}"
    const val Datastore = "androidx.datastore:datastore-preferences:${Version.datastore}"
}

object Coroutines {
    const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCore}"
    const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineCore}"
}

object Room {
    const val RunTime = "androidx.room:room-runtime:${Version.room}"
    const val Ktx = "androidx.room:room-ktx:${Version.room}"
    //Kapt
    const val Compiler = "androidx.room:room-compiler:${Version.room}"
}

object SupportLibraries {
    const val Ktx = "androidx.core:core-ktx:1.8.0"
    const val AppCompat = "androidx.appcompat:appcompat:1.5.0"
    const val Material = "com.google.android.material:material:1.6.1"
    const val Constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val Legacy = "androidx.legacy:legacy-support-v4:1.0.0"
}

object FirebaseLibraries {
    const val Firebase = "com.google.firebase:firebase-bom:29.3.1"
    const val Firestore = "com.google.firebase:firebase-firestore-ktx"

}

object TestLibraries {
    //Test
    const val Junit = "junit:junit:${Version.junit}"

    //AndroidTest
    const val TestRunner = "androidx.test.ext:junit:${Version.testRunner}"
    const val Espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}