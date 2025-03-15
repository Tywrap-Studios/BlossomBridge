---
tags:
  - Developer Guides
  - Configuration Module
  - Logging Module
---
# Creating a LoggingHandler

!!! warning
    This document assumes you have read and understood the part "Configuration".  
    If you haven't already, read it first and then come back.

> To maintain a consistent log format for all our mods, we decided to make a central class that handles all logging for them.

If you haven't already, make a `ConfigClass` and an accompanying `ConfigManager`, 
please note that you are forced to extend `BasicConfigClass` as the Type Parameter of a `LoggingHandler` 
will not accept a regular `ConfigClass` for the mere reason that it doesn't guarantee a `debug_mode` and `suppress_warns` value which are both needed for Logging.

Example Classes:
```java title="LoggingExample.java",linenums="1"
-8<- "docs/assets/code_examples/LoggingExampleMod.java:one"
```
???+ warning
    This class may look awfully empty as it misses a `validate()` method. This is because `BasicConfigClass` already has an implementation of it.  
    If you do decide to override the `validate()` method, make sure to run `super.validate()` in order to have `BasicConfigClass` properly validate too.
```java title="ExampleMod.java",linenums="1"
-8<- "docs/assets/code_examples/LoggingExampleMod.java:two"
```

We can now construct a new `LoggingHandler` in either of the following two ways:
=== "Manually inputting `Logger`s"
    ```java title="ExampleMod.java",linenums="1"
    -8<- "docs/assets/code_examples/LoggingExampleMod.java:three"
    ```
=== "Automatically generating `Logger`s (Recommended)"
    ```java title="ExampleMod.java",linenums="1"
    -8<- "docs/assets/code_examples/LoggingExampleMod.java:four"
    ```

In the next doc we'll see how to use this `LoggingHandler`.