# Vortex
Base Code To Build Android Applications Based On Clean , Mvvm Architecture

#### Status
Under Development

# Library Overview

In a lot of times you download all the Libraries and additions to be able to build your project in addition to that take a lot of time to build the base structure of your project and for this (Vortex) facilitates the stage of building the infrastructure of the project with all the additions needed by any Android project and the library consists of 4 Layers and each layer contain their own settings

# Library Components


- [x] Application Configuration
- [x] UI Implementation (Activity , Fragment)
- [x] Request Executor (Retrofit) , Request Provider (RxJava -> (Single , Flowable Observable))
- [x] Vortex Logic Layer (Store , Reducer , Request Reducer)
- [x] Vortex Errors , Models
- [x] Vortex Utils (Application Utils)
- [x] Fabric Configuration
- [x] Fabric With Timer Logger (Debug , Release)
- [x] Vortex Language Toggle
- [x] Clean Architecture Implementation
- [x] View Delegation
- [x] Recycler View Adapter
- [x] Permissions (Single , Multi) Based On (kotlin coroutines)
- [x] Application Shared Preferences
- [x] Image Loaders (Picasso , Fresco)
- [ ] Annotation Processor For Business Logic
- [ ] Annotation Processor For UI Layer
- [ ] Application State (User Story Tracker)
- [x] Request Executor (Single , Maybe , Observable)
- [x] Firebase Auth (Facebook , Google , Sign In Email - Pass , Register)
- [x] Firebase Firestore
- [ ] Firebase Realtime Database , Storage , Realtime Listening To Collection Changes

# Library Implementation Info

This Library Built On Kotlin coroutines
every method at this library is suspend function it means every process at the library execute on the background thread
you can change the thread at your view to ui thread 
[More Details](https://github.com/Kotlin/kotlinx.coroutines)

#### Stable Version : 1.0.1

# Setup

```
    repositories {
        maven {
            url  "https://dl.bintray.com/yt98/Vortex"
        }
    }
```

```
    dependencies {
        implementation "com.vortex:vortex-ui-ktx:${final_version}"
        implementation "com.vortex:vortex-permissions-ktx:${final_version}"
        implementation "com.vortex:vortex-core-ktx:${final_version}"
        implementation "com.vortex:vortex-logic-ktx:${final_version}"
        implementation "com.vortex:vortex-data-ktx:${final_version}"
        implementation "com.vortex:vortex-utils-ktx:${final_version}"
        implementation "com.vortex:vortex-prefs-ktx:${final_version}"
        implementation "com.vortex:vortex-firebase-ktx:${final_version}"
    }
```

# Contributing

Discussions and pull requests are welcomed. [The GitHub Contributors](https://github.com/Vortex-io/Vortex/graphs/contributors) Page has an entry in the App.


# Developers

(Yazan Tarifi) - Author -> yazantarifi1@hotmail.com

# License

Copyright (C) 2019 Vortex is An Open Source Library  (Licensed under the Apache License, Version 2.0)
