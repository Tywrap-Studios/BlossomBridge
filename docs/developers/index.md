---
tags:
  - Developer Guides
---
# Getting Started
Hello fellow developer, welcome to BlossomBridge!

## Importing into your IDE[^1]
[^1]: :fontawesome-solid-code: Integrated Development Environment, like IntelliJ IDEA or Eclipse.

You can get the BlossomBridge sources from the JitPack :simple-jitpack: maven repository.
=== "Groovy"
    ```groovy title="build.gradle",hl_lines="2-5 10"
    repositories {
        maven {
            name = 'JitPack'
            url = 'https://jitpack.io'
        }
    }   

    dependencies {
        ...
	    implementation "com.github.Tywrap-Studios:BlossomBridge:${project.blossombridge_version}"
    }
    ```
=== "Kotlin"
    ```kotlin title="build.gradle.kts",hl_lines="2-4 9"
    repositories {
        maven("https://jitpack.io") {
            name = "JitPack"
        }
    }

    dependencies {
        ...
        implementation("com.github.Tywrap-Studios:BlossomBridge:${project.blossombridge_version}")
    }
    ```

??? tip "Using Local files"
    Firstly, obtain a `blossombridge-<version>-sources.jar` from any of the following sources:
    === "Platform"
        BlossomBridge **pre-2.1.0** is available on Modrinth. You can get the jars [here](https://modrinth.com/mod/blossombridge/versions).
        Alternatively, you can get the latest version from the [Releases tab](https://github.com/Tywrap-Studios/BlossomBridge/releases) of the repository.
    === "Building"
        Clone the repository and run `./gradlew build` in the root directory of the project. Your sources jar will be in a folder called `build/libs`.
    === "GitHub Actions"
        1. On the main page of the Repository, click "Actions" :octicons-play-16: in the navigation bar on top.
        2. On the left-hand side, there is a list of Workflows :octicons-workflow-16:, click the one named `build`.
        3. Click into the top {==NON-FAILED==} action.
            1. You may filter by branch :octicons-git-branch-16: or release tag :octicons-tag-16: using the filters :octicons-filter-16: on the right side, or target a specific build in the list. This may be handy if you don't want to end up with an in-dev, unstable or broken version.
        4. Scroll down until you see a text named "Artifacts," after you click this a zip file containing the main jar and the sources jar will be downloaded onto your machine. Extract these jars and use the one that is affixed with `-sources.jar`.
    After getting said file, it is best to make a new directory in your project called `libs/`, and putting the jar inside it.

    Now you can manually add it to your repositories and dependencies:
    <div class="annotate" markdown>
    === "Groovy"
        ```groovy title="build.gradle",hl_lines="3-5 12"
        repositories {
            ...
            flatDir {
                dirs("path/too/libs") // (1)!
            }
        }

        dependencies {
            ...

	        // BlossomBridge
	        implementation ":BlossomBridge:${project.blossombridge_version}"
        }
        ```
    === "Kotlin"
        ```kotlin title="build.gradle.kts",hl_lines="3-5 12"
        repositories {
            ...
            flatDir {
                dirs("path/too/libs") // (1)!
            }
        }

        dependencies {
            ...

	        // BlossomBridge
	        implementation(":BlossomBridge:${project.blossombridge_version}")
        }
        ```
    </div>

    1.  Tip: you can use `:::groovy ${rootProject.projectDir}` to reference the root of your project.

### Finalizing [![](https://jitpack.io/v/Tywrap-Studios/BlossomBridge.svg)](https://jitpack.io/#Tywrap-Studios/BlossomBridge)
Finally, add the following to your `gradle.properties` file:
```properties
blossombridge_version=x.y.z
```
And replace `x.y.z` with your major, minor and patch version, e.g. {==2.1.0==}.
???+ tip "When using JitPack"
    JitPack might not have made an Artifact yet, if your imports are failing, go over to the JitPack page of the repository and check if a build might have failed.
???+ tip "Local versioning"
    If you are using a local jar, check if the version in the file name corresponds with the version you're trying to use.  
    Because of the use of `flatDir`, you don't need to include the artifact pat