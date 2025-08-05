---
tags:
  - Developer Guides
---
# 2.0.2 -> 2.1.0

2.1.0 had one goal: make the project available across any project.

## Changes:
1. The API is no longer a mod, but a library that can be used in any Java or Kotlin project.
    1. It no longer has mod metadata (such as an id, name, version, etc.), and won't be loaded by any mod loader.
    2. Jankson is now included using the `api` 
2. The deprecation of `BasicConfigClassKt` is now marked as `DeprecationLevel.ERROR`. If you haven't migrated to the new Java equivalent yet, do so. Will be fully removed in the next patch when possible.
3. `LoggingHandler` now has methods to get the current `Logger` instances.
4. `LoggingHandler` is now capable of running vararg log methods, to make full use of SLF4J.

## Updating
Due to the change to be like this and no longer be a mod, you must note that it is recommended to include the artifacts 
with your program, and no longer externally depend on the API. In the getting [started guide](index.md) you can view an 
up-to-date tutorial on how to do this.

Also note that after {==2.1.0==} going forward, we won't be publishing BBAPI on Modrinth anymore. Please include the API in your project.

### Migration
1. Make sure you're now bundling the API with your project, and not depending on it externally.
   1. This may differ per tool.
2. If you were using `BasicConfigClassKt`, migrate to the Java one.

Change the version in your `gradle.properties` or `libs.toml` to `2.1.0` and you're set.