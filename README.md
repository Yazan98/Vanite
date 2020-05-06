# Vortex

Android Infrastructure

![](https://img.shields.io/badge/Project%20Status-Under%20Development-blue)
![](https://img.shields.io/badge/Version-2.0.0-brightgreen)
![](https://img.shields.io/badge/License-Apache%202.0-yellow)
![](https://img.shields.io/badge/Language-Kotlin-orange)
![](https://img.shields.io/badge/Android%20Status-AndroidX-green)

# What is Vortex

Vortex is an Android Infrastructure To Build Android Applications With Latest Technologies and Ready State Handling with User Interface Implementation For The Android Common Cases
This Library is Not Just Base Code it's also help you to get the target as soon as possible with ready techniques, base code for everything and this library built on modularity architecture
actually you can depends on Vortex To Build Any Kind Of Android Apps , but the problem here this library depends on other android apis to implement some operations
like google maps and 3th libraries to make sure your application has the right dependencies to start using Vortex Library you should apply 2 Gradle Plugins
The First One For Vortex Dependcies With Multi Modular Application To Apply The Right Dependency to Right Module, the Second one should provide the application the right dependencies to each module

# Multi Modular Application
Vortex has Main 3 Modules you should include in your app to install Vortex

> Note: Vortex Don't Support Single Module Application Gradle Plugins Don't Working With Single Module

Each Application Should Implemented With 3 Layers (ui, data, domain)
1. UI -> User Interface it includes (Activities, Fragments, Notifications, Dialogs, Application Configuration) -- Optional Dagger Application Scope

2. DATA -> The Data Layer Should Implement RxJava With Retrofit To Handle Api Requests with Local Database Configuration and Shared Prefs Keys

3. DOMAIN -> This Layer Should include The ViewModels With Application Business Logic Because Each ViewModel has The Hole Logic For Each Section and this is the important part in the application for this all ViewModels in the Same Layer

# Vortex Logic Handling
1. State : Vortex is Working Depends on Android Architecture Component it means The Base Layer in Vortex is ViewModel and The Application State Management Depends On LiveData Handling
There are a lot of ways you can deliver the Direct State to View With Ready State or Custom State

#### Vortex State Types
1.1 : State, Action Handling : This Way Requires Two Parameters The First One is Action and The Second One The Base State For This ViewModel
You can Use This Way To Create ViewModel That Can Handle The SuccessState, ErrorState, LoadingState, EmptyState and This Way Inspired From Redux State Handling
And The Action Will explain later

1.2 : PureViewModel : This ViewModel Don't Requires Any Parameters and Just Handle The RxJava Disposables With ViewModel Lifecycle

1.3 : SingleStateViewModel : This ViewModel don't Require Actions Just State and You Can pass any type of actions life Int (Keys), Objects also This ViewModel handle The Loading State 

1.4 : ReadyStateViewModel : This ViewModel has The Ready State For Common Operations in any ViewModel like (EMPTY, LOADING, ERROR, SUCCESS)

1.5 : IndirectViewModel : This ViewModel like SingleStateViewModel but it just handle The State Without Loading Handling

#### Vortex Actions

Vortex ViewModels and Views Requires The Actions Because any View Can Just send Actions To Any Type of ViewModel using execute Method
in this case You can Declare The Base Action And Handle The Childes 

Here You Can Tell The ViewModel You Should Handle The Auth Actions And The Childes Of This Action is Login, Register Actions Just and Don't Handle Anything Else

# Setup

Packages Information : [Bintray](https://bintray.com/yt98/Vortex)

1. The Build.gradle Root File

```
repositories {
   maven {
     url  "https://dl.bintray.com/yt98/Vortex"
   }
}
```

2. Application Module

```
dependencies {
        def VortexVersion = "2.0.0"
        implementation "io.vortex:vortex-ui-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-permissions-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-core-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-local-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-data-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-utils-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-prefs-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-firebase-ktx:${VortexVersion}"
        implementation "io.vortex:vortex-logger-ktx:${VortexVersion}"
}
```

<<<<<<< HEAD
# Vortex Gradle Plugin

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.io.vortex.gradle.plugin.dependencies:vortex-dependencies-plugin:1.0.0"
  }
}
```

3. Each Module Should Implement The Plugin 

```
apply plugin: "io.vortex.gradle.plugin.dependencies"
```
=======
# Vortex Decumenetation
Coming Soon Vortex still Under Development
>>>>>>> 96fc8d4ea3a003708c41f6ec670e7fb21ae35a63

# License

Copyright (C) 2019 Vortex is An Open Source Library (Licensed under the Apache License, Version 2.0)

