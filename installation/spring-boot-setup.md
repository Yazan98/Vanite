---
description: The Spring Boot Version Configuration
---

# Spring Boot Setup

Gradle implementation

```text
repositories {
   maven {
     url  "https://dl.bintray.com/yt98/Vortex"
   }
}
```

Gradle Module implementation

```text
 dependencies {
        implementation "io.vortex:vortex-spring-boot:1.0.11"
}
```

Maven Implementation

```text
<dependency>
  <groupId>io.vortex</groupId>
  <artifactId>vortex-spring-boot</artifactId>
  <version>1.0.11</version>
  <type>pom</type>
</dependency>
```



