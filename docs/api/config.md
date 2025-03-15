---
tags:
  - Developer Guides
  - Configuration Module
---
# Configuration

> BlossomBridge provides a simple, albeit plain, way to add Config to your mod using JSON5 files loaded using Jankson.

Start by making a new class and implementing `ConfigClass`:
```java title="ConfigClassExample.java",linenums="1"
-8<- "docs/assets/code_examples/ConfigClassExample.java:one"
```

Due to the implementation, you are forced to make a `validate()` method. This method is run every time your Config is read and deserialized to ensure your Config isn't invalid according to your validation.
We will look into using this later. :octicons-clock-16:

```java title="ConfigClassExample.java",linenums="1"
-8<- "docs/assets/code_examples/ConfigClassExample.java:two"
```

Adding data is possible as follows:
```java title="ConfigClassExample.java",linenums="1"
-8<- "docs/assets/code_examples/ConfigClassExample.java:three"
```

1.  The field name is the key in the json5 file, you can set a default value by {==initialising the field==}.
2.  Nested configs are possible by using {==static inner classes==}, look at the next annotation for more info.
3.  By making a static inner class, and putting fields in it, you essentially create a nested config. (1)
{ .annotate }

    1.  A nested config is a config option that is part of another config (kind of like this annotation :smile:), you reference them like `util_config.debug_mode` and `util_config.suppress_warns`.

??? tip "Jankson Comments :octicons-comment-discussion-16:"
    If you chose to [add and include Jankson](index.md#prerequisites), you can use comments as follows:
    ```java title="ConfigClassExample.java"
    -8<- "docs/assets/code_examples/ConfigClassExample.java:janksonComments"
    ```
    It will look like this:
    ```json5
    -8<- "docs/assets/code_examples/ConfigClassExample.java:janksonCommentsJson"
    ```

How nice, in the next doc we will look into using `validate()` to validate your values!