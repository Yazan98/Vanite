# Vortex Plugins

Vortex Android Application Requires A lot Of Things To Config The Application Thats why Vortex Needs The Gradle Plugins

# Overview
This Repository Has 2 Gradle Plugins 

1. Vortex Dependencies Plugin
2. Vortex Safety Depedencies Plugin

The First One Allows you to Apply Vortex Dependencies with Multi Modular Applications with Specific Pattern
The Parent Layer name is ui, app and the plugin should apply the required dependencies depends on module name
The Other Layers is data, domain

# Setup

1. Plugin DSL (Optional)

```
plugins {
  id "io.vortex.gradle.plugin.dependencies" version "1.0.0"
}
```

2. Legacy Plugin Setup

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

# License
Copyright (C) 2019 Vortex Gradle Plugin is An Open Source Library (Licensed under the Apache License, Version 2.0)

