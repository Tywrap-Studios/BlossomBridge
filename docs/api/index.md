# API Reference

In this part of the docs we will look at a basic setup using BlossomBridge!

## Prerequisites
???+ tip "Jankson"
    Before we start, if you'd like to add Comments :octicons-comment-discussion-16: to your Config file, you will have to install and include Jankson in your Gradle :simple-gradle: project.
    === "Groovy"
        ```groovy title="build.gradle",hl_lines="5"
        dependencies {
            ...

	        // blossombridge
	        implementation(include("blue.endless:jankson:${project.jankson_version}"))
        }
        ```
    And add `:::properties jankson_version=1.2.3` to your `gradle.properties` :octicons-file-code-16: file. (or any other version you may want to use)