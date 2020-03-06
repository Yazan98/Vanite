package io.vortex.cli.generators.gradle

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class GradleLibrariesFileGenerator : VortexBaseGenerator() {

    companion object {
        const val KoinVersion = "KoinVersion"
        const val TimberV = "TimberV"
        const val MultiDexAppV = "MultiDexAppV"
        const val LeakCanaryV = "LeakCanaryV"
        const val KotlinV = "KotlinV"
        const val CoroutinesV = "CoroutinesV"
        const val SupportLibV = "SupportLibV"
        const val daggerV = "daggerV"
        const val motifV = "motifV"
        const val JunitV = "JunitV"
        const val FrescoV = "FrescoV"
        const val SdpV = "SdpV"
        const val ConstraintlayoutV = "ConstraintlayoutV"
        const val NavigationFragmentV = "NavigationFragmentV"
        const val RxJavaV = "RxJavaV"
        const val RxAndroidV = "RxAndroidV"
        const val RunnerV = "RunnerV"
        const val RetrofitV = "RetrofitV"
        const val VortexV = "VortexV"
        const val RoomV = "RoomV"
        const val EsspressoV = "EsspressoV"
        const val RetrofitiInterceptorV = "RetrofitiInterceptorV"
        const val RetrofitGsonAdapterV = "RetrofitGsonAdapterV"
        const val LifeCycleV = "LifeCycleV"
        const val googlePlayServicesV = "googlePlayServicesV"
    }

    override fun getFileType(): VortexFileType {
        return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
ext {
    // Versions
    KoinVersion = "2.0.1"
    MultiDexAppV = "1.0.3"
    TimberV = "4.7.1"
    LeakCanaryV = "2.0-alpha-1"
    SupportLibV = "1.0.0"
    KotlinV = "1.3.50"
    FrescoV = "1.13.0"
    CoroutinesV = "1.3.3"
    NavigationFragmentV = "2.2.0-rc04"
    ConstraintlayoutV = "2.0.0-beta4"
    RxJavaV = "2.2.11"
    RxAndroidV = "2.1.1"
    RetrofitV = "2.6.1"
    RoomV = "2.2.3"
    ParcelablePleaseV = "1.0.2"
    LifeCycleV = "2.2.0-rc03"
    googlePlayServicesV = "16.0.0"
    EsspressoV = "3.2.0"
    RunnerV = "1.2.0"
    JunitV = "4.12"
    SdpV = "1.0.6"
    motifV = "0.0.10"
    daggerV = "2.24"
    VortexV = "1.0.11"
    RetrofitiInterceptorV = "3.12.1"
    RetrofitGsonAdapterV = "2.5.0"

    //Libraries
    KoinConfiguration = [
        KoinAndroid : "org.koin:koin-android:$$KoinVersion",
        KoinLifecycle: "org.koin:koin-android-scope:$${KoinVersion}",
        KoinViewModel : "org.koin:koin-android-viewmodel:$${KoinVersion}"
    ]

    ApplicationConfiguration = [
        Timber       : "com.jakewharton.timber:timber:$$TimberV",
        MultiDexApp  : "com.android.support:multidex:$$MultiDexAppV",
        LeakCanaryAndroid        : "com.squareup.leakcanary:leakcanary-android:$$LeakCanaryV",
        LeakCanary   : "com.squareup.leakcanary:leaksentry:$$LeakCanaryV",
        KotlinJdk    : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$$KotlinV"
    ]

    KotlinCoroutinesConfiguration = [
        Coroutines       : "org.jetbrains.kotlinx:kotlinx-coroutines-core:$$CoroutinesV",
        AndroidCoroutines: "org.jetbrains.kotlinx:kotlinx-coroutines-android:$$CoroutinesV"
    ]

    UiConfiguration = [
        RecyclerView      : "androidx.recyclerview:recyclerview:$$SupportLibV",
        SupportCompat     : "com.android.support:support-compat:$$SupportLibV",
        SupportCore       : "com.android.support:support-core-utils:$$SupportLibV",
        SupportCoreUi     : "com.android.support:support-core-ui:$$SupportLibV",
        SupportFragment   : "com.android.support:support-fragment:$$SupportLibV",
        AndroidCore       : "androidx.core:core-ktx:$$SupportLibV",
        CardView          : "androidx.cardview:cardview:$$SupportLibV",
        AppCompat         : "androidx.appcompat:appcompat:$$SupportLibV",
        GoogleMaterial    : "com.google.android.material:material:$$SupportLibV",
        Fresco: "com.facebook.fresco:fresco:$$FrescoV",
        Sdp   : "com.intuit.sdp:sdp-android:$$SdpV",
        Constraintlayout  : "androidx.constraintlayout:constraintlayout:$$ConstraintlayoutV",
        NavigationFragment: "androidx.navigation:navigation-fragment-ktx:$$NavigationFragmentV",
        NavigationUI      : "androidx.navigation:navigation-ui-ktx:$$NavigationFragmentV"
    ]

    RxConfiguration = [
        RxJava   : "io.reactivex.rxjava2:rxjava:$$RxJavaV",
        RxAndroid: "io.reactivex.rxjava2:rxandroid:$$RxAndroidV"
    ]

    DataConfiguration = [
        Retrofit : "com.squareup.retrofit2:retrofit:$$RetrofitV",
        RetrofitRxJavaAdapter: "com.squareup.retrofit2:adapter-rxjava2:$$RetrofitV",
        RetrofitIntercenptor : "com.squareup.okhttp3:logging-interceptor:$$RetrofitiInterceptorV",
        retrofitGsonConverter: "com.squareup.retrofit2:converter-gson:$$RetrofitGsonAdapterV"
    ]

    RoomConfiguration = [
        RoomRuntime : "androidx.room:room-runtime:$$RoomV",
        RoomCompiler: "androidx.room:room-compiler:$$RoomV",
        RoomKotlin  : "androidx.room:room-ktx:$$RoomV",
        RoomRxJava  : "androidx.room:room-rxjava2:$$RoomV"
    ]

    LifeCycleConfiguration = [
        LifecycleViewModel  : "androidx.lifecycle:lifecycle-viewmodel-ktx:$$LifeCycleV",
        LifecycleExtensions : "androidx.lifecycle:lifecycle-extensions:$$LifeCycleV",
        LifecycleRuntime    : "androidx.lifecycle:lifecycle-runtime:$$LifeCycleV",
        LifecycleLiveData   : "androidx.lifecycle:lifecycle-livedata:$$LifeCycleV",
        LifecycleCommon     : "androidx.lifecycle:lifecycle-common:$$LifeCycleV"
    ]

    GooglePlayServices = [
        GoogleMaps     : "com.google.android.gms:play-services-maps:$${googlePlayServicesV}",
        GooglePlaces   : "com.google.android.gms:play-services-places:$${googlePlayServicesV}",
        GoogleGcm      : "com.google.android.gms:play-services-gcm:$${googlePlayServicesV}",
        GoogleLocations: "com.google.android.gms:play-services-location:$${googlePlayServicesV}"
    ]

    TestingConfiguration = [
        Esspresso: "androidx.test.espresso:espresso-core:$$EsspressoV",
        Runner   : "androidx.test:runner:$$RunnerV",
        Junit    : "junit:junit:$$JunitV"
    ]

    DependenciesInjection = [
        MotifCompiler : "com.uber.motif:motif-compiler:$$motifV",
        Motif : "com.uber.motif:motif:$$motifV",
        Dagger: "com.google.dagger:dagger:$$daggerV",
        DaggerCompiler : "com.google.dagger:dagger-compiler:$$daggerV",
        DaggerAndroid : "com.google.dagger:dagger-android:$$daggerV",
        DaggerAndroidSupport : "com.google.dagger:dagger-android-support:$$daggerV",
        DaggerAndroidProcessor: "com.google.dagger:dagger-android-processor:$$daggerV"
    ]

    VortexConfiguration = [
        VortexUserInterface : "io.vortex:vortex-ui-ktx:$${VortexV}",
        VortexPermissions : "io.vortex:vortex-permissions-ktx:$$VortexV",
        VortexCore : "io.vortex:vortex-core-ktx:$$VortexV",
        VortexLocal: "io.vortex:vortex-local-ktx:$$VortexV",
        VortexData: "io.vortex:vortex-data-ktx:$$VortexV",
        VortexExtras: "io.vortex:vortex-utils-ktx:$$VortexV",
        VortexPrefs: "io.vortex:vortex-prefs-ktx:$$VortexV",
        VortexFirebase: "io.vortex:vortex-firebase-ktx:$$VortexV"
    ]

}""".trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "Libraries"
    }

}
