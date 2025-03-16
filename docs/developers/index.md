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
    ```groovy title="build.gradle",hl_lines="2 9"
    repositories {
        maven { url = 'https://jitpack.io' }
    }   

    dependencies {
        ...

	    // BlossomBridge
	    modImplementation "com.github.Tywrap-Studios:BlossomBridge:${project.blossombridge_version}"
    }
    ```
??? tip "Using Local files"
    Firstly, obtain a `blossombridge-<version>-sources.jar` from any of the following sources:
    === "Platform"
        Currently, BlossomBridge is only available on Modrinth. You can get the jars [here](https://modrinth.com/mod/blossombridge).
    === "Building"
        You can do this by cloning the repository and running `./gradlew build` in the root directory of the project. Your sources jar will be in a folder called `build/libs`.
    === "GitHub Actions"
        1. On the main page of the Repository, click "Actions" :octicons-play-16: in the navigation bar on top.
        2. On the left hand side, there is a list of Workflows :octicons-workflow-16:, click the one named `build`.
        3. Click into the top {==NON-FAILED==} action.
            1. You may filter by branch :octicons-git-branch-16: or release tag :octicons-tag-16: using the filters :octicons-filter-16: on the right side, or target a specific build in the list. This may be handy if you don't want to end up with an in-dev, unstable or broken version.
        4. Scroll down until you see a text named "Artifacts", after you click this a zip file containing the main jar and the sources jar will be downloaded onto your machine. Extract these jars and use the one that is affixed with `-sources.jar`.
    After obtaining said file, it is best to make a new directory in your project called `libs/`, and put the jar inside of it.

    Now you can manually add it to your repositories and dependencies:
    === "Groovy"
        ```groovy title="build.gradle",hl_lines="5"
        dependencies {
            ...

	        // blossombridge
	        modImplementation files("libs/blossombridge-${project.blossombridge_version}-sources.jar")
        }
        ```

### Finalizing [![](https://jitpack.io/v/Tywrap-Studios/BlossomBridge.svg)](https://jitpack.io/#Tywrap-Studios/BlossomBridge)
Finally, add the following to your `gradle.properties` file:
```properties
blossombridge_version=x.y.z
```
and this to your `fabric.mod.json`:
```json
{
  "depends": {
    "blossombridge": ">=x.y.z"
  }
}
```
And replace `x.y.z` with your major, minor and patch version, e.g. {==2.0.0==}.
???+ tip "When using JitPack"
    JitPack might not have made an Artifact yet, if your imports are failing, go over to the JitPack page of the repository and check if a build might have failed.
???+ tip "Local versioning"
    If you are using a local jar, check if the version in the file name corresponds with the version you're trying to use.