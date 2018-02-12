[![](https://jitpack.io/v/eddmash/androidcomponents.svg)](https://jitpack.io/#eddmash/androidcomponents)

Android components
==================

This is a demo project to show case usage of the different android libraries i have developed
and are available for use. 

Read the [Documentation](http://android-components.readthedocs.io/) for each of the components.

This components are hosted via jitpack

How to use
----------
Step 1. Add the JitPack repository to your build file of you project

```
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
	
```

Step 2. Add the component you require on you apps build file

```
dependencies {
    compile 'com.github.eddmash.androidcomponents:activerecord:2.0.3'
    compile 'com.github.eddmash:androidcomponents:grid:2.0.3'
    compile 'com.github.eddmash:androidcomponents:form:2.0.3'
    compile 'com.github.eddmash:androidcomponents:validation:2.0.3'
    compile 'com.github.eddmash:androidcomponents:pagination:2.0.3'
    compile 'com.github.eddmash:androidcomponents:adapter:2.0.3'
    compile 'com.github.eddmash:androidcomponents:views:2.0.3'
    compile 'com.github.eddmash:androidcomponents:dialogs:2.0.3'
}
```