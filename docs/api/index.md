# API Reference

In this part of the docs, we will look at a basic setup using BlossomBridge!

## Prerequisites
???+ tip "Jankson"
    Jankson is a JSON5 parser and serializer library that BlossomBridge uses to read and write configuration files.  
    It allows for comments, multi-line strings, and more, making it easier to work with configuration files in a human-readable format.  

    Technically, Jankson is a dependency of BlossomBridge using the `api` keyword, so you don't have to add it separately if you're using BlossomBridge as a dependency in your project if you want to use it.

    If this for some reason doesn't work, you can do the following to add it to your Gradle project:
    === "Groovy"
        ```groovy title="build.gradle",hl_lines="3"
        dependencies {
            ...
	        implementation "blue.endless:jankson:${project.jankson_version}"
        }
        ```
    === "Kotlin"
        ```kotlin title="build.gradle.kts",hl_lines="3"
        dependencies {
            ...
            implementation("blue.endless:jankson:${project.jankson_version}")
        }
        ```
    And add `:::properties jankson_version=1.2.3` to your `gradle.properties` :octicons-file-code-16: file. (or any other version or version catalogue you may want to use)