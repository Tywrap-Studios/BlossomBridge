---
tags:
  - Developer Guides
  - Configuration Module
---
# Config Files

> Ok that's very cool and stuff, but how do we actually turn this into json5 files and use it in our code?

As mentioned a few times before, BlossomBridge utilises a library called Jankson to parse, read, (de)serialise and write json5 files.

An implementation of using Jankson with our `ConfigClass` is a `ConfigManager`!

A `ConfigManager` can be created to do various things with your Config instance, such as saving or loading it, but also getting Strings that hold the plain json5 code.

In order to create a new `ConfigManager` we need a few things:

1. A `File` where we store our json5 code.
2. A `ConfigClass` where we get our data from.

Create a new `ConfigManager` in your `ModInitializer` class, let's use our `ValidateExample` class as the `ConfigClass`:
```java title="ExampleMod.java",linenums="1",hl_lines="2-5"
-8<- "docs/assets/code_examples/ExampleMod.java:one"
```
??? note
    `ConfigManager` has a {==Type Parameter==} of `T extends ConfigClass?`, meaning you need to put a class that implements `ConfigClass` in between the `<>`.

Currently, though, this still does nothing. Because in order to actually make Jankson start reading from and writing to the
Config file, you need to load it as follows:
```java title="ExampleMod.java",linenums="1",hl_lines="7"
-8<- "docs/assets/code_examples/ExampleMod.java:two"
```

!!! note
    If it's your first time loading the Config file, it will create a new file with the default values and *then* put the values into a config instance.  
    If the mod has been loaded multiple times before, it will apply your validation code from [the last doc](config_validation.md) and then turn it into a config instance.

You can access the current Config Instance by running `:::java CONFIG_MANAGER.getConfig()`

Example Usage:
```java title="ExampleMod.java",linenums="1",hl_lines="9-10"
-8<- "docs/assets/code_examples/ExampleMod.java:three"
```

!!! note
    You can find your config file at `run/config/<name>.json5` unless you set a different `File` for the `ConfigManager`.


And that's it! It might be finicky at first, but messing around with it as much as you can is definitely suggested and especially fun if it works!

In the next docs we can look at how you can set up Logging with your Config.