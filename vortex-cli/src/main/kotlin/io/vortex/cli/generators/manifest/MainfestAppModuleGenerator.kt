package io.vortex.cli.generators.manifest

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class MainfestAppModuleGenerator(private val packageName: String) : VortexBaseGenerator() {

    override fun getFileType(): VortexFileType {
        return VortexFileType.XML
    }

    override fun getFileContent(): String {
        return """
            <?xml version="1.0" encoding="UTF-8"?>

            -<manifest android:installLocation="preferExternal" package="${packageName}" xmlns:android="http://schemas.android.com/apk/res/android">

            <uses-permission android:name="android.permission.INTERNET"/>

            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

            <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>

            <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

            <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>


            -<application android:name=".AutohubApplication" android:theme="@style/AppTheme" android:supportsRtl="true" android:roundIcon="@mipmap/ic_launcher_round" android:label="@string/app_name" android:icon="@mipmap/ic_launcher" android:allowBackup="true">

            -<activity android:name=".screen.SplashScreen" android:theme="@style/SplashScreenTheme" android:screenOrientation="portrait">


            -<intent-filter>

            <action android:name="android.intent.action.MAIN"/>

            <category android:name="android.intent.category.LAUNCHER"/>

            </intent-filter>

            </activity>

            </application>

            </manifest>
        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".xml"
    }

    override fun getFilePath(): String {
        return "app/src/main/AndroidManifest"
    }
}