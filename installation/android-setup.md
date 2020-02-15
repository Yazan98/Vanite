---
description: The android Gradle Installation
---

# Android Setup

Android Gradle Root File Configuration

```text
repositories {
   maven {
     url  "https://dl.bintray.com/yt98/Vortex"
   }
}
```

Android All Projects Gradle block 

```text
allprojects {

    repositories {
        google()
        jcenter()
        maven { url "https://dl.bintray.com/yt98/Vortex" }
    }

}
```

App Module Configuration

```text
dependencies {
        def VortexVersion = "1.0.13"
        implementation "io.vortex:vortex-ui-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-permissions-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-core-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-local-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-data-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-utils-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-prefs-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-firebase-ktx:${VortexVersion}"
}
```

After Add The Gradle Configuration You Can Start But Vortex Android State Handler can't Work Without Android ViewModel Implementation Check the Following Link

{% page-ref page="android-setup.md" %}

