# Vortex
Base Code To Build Android Applications Based On Clean , Redux Architecture

![](https://img.shields.io/badge/License-Apache%202.0-blue)
![](https://img.shields.io/badge/Project%20Status-Beta%20Version-yellow)
![](https://img.shields.io/badge/Android%20Status-AndroidX-green)
![](https://img.shields.io/badge/Version-1.0.11-orange)
![](https://img.shields.io/badge/Language-Kotlin-orange)

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
- [x] Notifications Channels (Enable , Disable , Create)
- [x] Network Interceptor
- [ ] Application State (User Story Tracker)
- [x] Gif Animation Controller (Fresco , Glide)
- [x] Request Executor (Single , Maybe , Observable)
- [x] Firebase Auth (Facebook , Google , Sign In Email - Pass , Register)
- [x] Firebase Firestore
- [x] Google Maps
- [x] Language Manager
- [ ] Firebase Realtime Database , Storage , Realtime Listening To Collection Changes

# Library Implementation Info

This Library Built On Kotlin coroutines
every method at this library is suspend function it means every process at the library execute on the background thread
you can change the thread at your view to ui thread 
[More Details](https://github.com/Kotlin/kotlinx.coroutines)

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
        implementation "io.vortex:vortex-ui-ktx:${final_version}"
        implementation "io.vortex:vortex-permissions-ktx:${final_version}"
        implementation "io.vortex:vortex-core-ktx:${final_version}"
        implementation "io.vortex:vortex-logic-ktx:${final_version}"
        implementation "io.vortex:vortex-data-ktx:${final_version}"
        implementation "io.vortex:vortex-utils-ktx:${final_version}"
        implementation "io.vortex:vortex-prefs-ktx:${final_version}"
        implementation "io.vortex:vortex-firebase-ktx:${final_version}"
    }
```

# Sample

You Can Find Kotlin Example At The Following Link

[Kotlin Example](https://github.com/Vortex-io/Examples/tree/master/Android)

# Contributing


To contribute to Vortex , follow these steps:

1. Fork this repository.
2. Create a branch: git checkout -b <branch_name>.
3. Make your changes and commit them: `git commit -m '<commit_message>'
4. Push to the original branch: git push origin <project_name>/<location>
5. Create the pull request.

# Developers

(Yazan Tarifi) - Author -> yazantarifi1@hotmail.com

# License

Copyright (C) 2019 Vortex is An Open Source Library  (Licensed under the Apache License, Version 2.0)
