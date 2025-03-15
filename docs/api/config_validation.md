---
tags:
  - Developer Guides
  - Configuration Module
---
# Ranges, Sets and Validation

> Picture this! You want your users to be able to add a certain amount of orbs to their world, but no more than 60, but uhhh, there needs to be at least one!

In order to achieve this we can "define" ranges for your config values using the `validate()` method!

Start by making some value(s) in your config class, in our case we will use `orbs`:
```java title="ValidateExample.java",linenums="1",hl_lines="2"
-8<- "docs/assets/code_examples/ValidateExample.java:one"
```

We can enforce a range by checking the value of `orbs` in the `validate()` method:
```java title="ValidateExample.java",linenums="1",hl_lines="6-10"
-8<- "docs/assets/code_examples/ValidateExample.java:two"
```

We check if the value orbs is lower than 1 or higher than 60, if it is, we reset the value back to `1`!  
!!! tip
    If you can use [Comments](index.md#prerequisites), try to make your users aware of this range by stating it in a Comment!

We can do the same logic for all sorts of Types, such as Strings:
```java title="ValidateExample.java",linenums="1",hl_lines="3 13-18"
-8<- "docs/assets/code_examples/ValidateExample.java:three"
```

1.  You could also make an enum class and use `.values()`!

!!! example "Throwing RuntimeExceptions"
    Not feeling like automatically correcting your user's mistakes and just make their runtime throw an exception?  
    BlossomBridge provides two `RuntimeException`s you can throw in case something went wrong when loading your Config.
    === "`InvalidConfigFileException`"
        Seems self-explanatory, if the file is invalid, throw this exception and call it a day.
    === "`InvalidConfigFormatException`"
        For those who regularly change their Config data, setting so-called "Config Versions" may be a smart idea.
        If you wish to throw an exception when a Config Version set inside a config file is invalid/outdated, you can throw this exception!

In the next doc we'll be looking at how to actually use our files and data!