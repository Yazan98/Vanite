# Vanite

![New Project](https://user-images.githubusercontent.com/29167110/158914920-32310149-7f76-4802-9745-6c5ecf05f335.png)


![](https://img.shields.io/badge/Project%20Status-Under%20Development-blue)
[![Maven Central](https://img.shields.io/maven-central/v/com.yazantarifi/vanite.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.yazantarifi%22%20AND%20a:%22vanite%22)
![](https://img.shields.io/badge/License-Apache%202.0-yellow)
![](https://img.shields.io/badge/Language-Kotlin-orange)
![](https://img.shields.io/badge/Android%20Status-AndroidX-green)


# What is Vanite

Vanite is an Open Source Library That Focus on Providing The Base Code of Android Applications with Utility Classes For Common Use Cases
Under Multi Modular Architecture From Managing the State to Utils Classes to Providing Base Code in Base ViewModels, Fragments, Activities

### Multi Modular Application
The Library Focus on Main Modules
1. UI
2. Data
3. Domain

The UI Layer Contact with Domain to handle the logic from ViewModels, Use Cases, etc and This Layer Contact with Data Layer to get the Data from Repositories, this Layers could be provided by Modules or Packages because vanite is Built based on Modules and you can add the Required Dependency to one Module as you want


### Application Flow Components
1. Actions
2. State
3. ViewModel
4. User Interface

The UI Contact With ViewModel By execute Method Only and Send to ViewModel Actions, Each Action Should Execute specific Code or move to Use Case
Then ViewModel Respond to View With New State For This ViewModel

Also to Provide Utility Classes As much as Possible for Common Use Cases

### Setup

1. The Build.gradle Root File

```
allprojects {
    repositories {
        mavenCentral()
    }
}
```

2. Application Module

```
dependencies {
   implementation 'com.yazantarifi:vanite:2.0.0'
   implementation 'com.yazantarifi:vanite-data:2.0.0'
   implementation 'com.yazantarifi:vanite-utils:2.0.0'
   implementation 'com.yazantarifi:vanite-ui-binding:2.0.0'
   implementation 'com.yazantarifi:vanite-ui:2.0.0'
   implementation 'com.yazantarifi:vanite-prefs:2.0.0'
   implementation 'com.yazantarifi:vanite-permissions:2.0.0'
   implementation 'com.yazantarifi:vanite-log:2.0.0'
   implementation 'com.yazantarifi:vanite-firebase:2.0.0'
   implementation 'com.yazantarifi:vanite-secured-prefs:2.0.0'
   implementation 'com.yazantarifi:vanite-compose:2.0.0'
}
```

# Library Dependencies Description

This Library has 2 Ways to Create the Integration, first We have applications Built based on XML and Other Apps Built with Jetpack Compose
this Library Support Jetpack Compose Applications Under one Dependency that has the base code for Composables 

Dependency Information for Jetpack Compose Applications

```
    implementation 'com.yazantarifi:vanite-compose:2.0.0'
```

Dependency Information for XML Applications


```
   implementation 'com.yazantarifi:vanite:2.0.0'
   implementation 'com.yazantarifi:vanite-data:2.0.0'
   implementation 'com.yazantarifi:vanite-utils:2.0.0'
   implementation 'com.yazantarifi:vanite-ui-binding:2.0.0'
   implementation 'com.yazantarifi:vanite-ui:2.0.0'
```

Dependency Information for Utility Classes

```
   implementation 'com.yazantarifi:vanite-secured-prefs:2.0.0'
   implementation 'com.yazantarifi:vanite-firebase:2.0.0'
   implementation 'com.yazantarifi:vanite-log:2.0.0'
   implementation 'com.yazantarifi:vanite-permissions:2.0.0'
   implementation 'com.yazantarifi:vanite-utils:2.0.0'

```


# Push Update

> This Command Will Generate Build File and Jars for All Modules

```
    gradle publishReleasePublicationToSonatypeRepository
```

# Vanite Documentation
Coming Soon Vanite still Under Development

# License

Copyright (C) 2019 Vanite is An Open Source Library (Licensed under the Apache License, Version 2.0)

