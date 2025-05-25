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

!!! Info
    In this example, we are picturing you are using BBAPI for a Minecraft mod. But in theory, the same logic applies to any project!

Create a new `ConfigManager` in your initialising class, let's use our `ValidateExample` class as the `ConfigClass`:
```java title="ExampleMod.java",linenums="1",hl_lines="2-5"
-8<- "docs/assets/code_examples/ExampleMod.java:one"
```

Currently, though, this still does nothing. Because in order to actually make Jankson start reading from and writing to the
Config file, you need to load it once during initialisation as follows:
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

??? note "Fabric mod config path"
    In this example, where it's a Minecraft Fabric mod, you can find your config file at `run/config/<name>.json5` unless you set a different `File` for the `ConfigManager`.

!!! warning "Applying changes"
    If a user changes any values inside of the `.json5` file they won't be immediately applied to your config instance.
    Before you can apply these changes, you need to reload your config file. You do this by running the same method, `:::java ConfigManager.loadConfig()`

And that's it! It might be finicky at first, but messing around with it as much as you can is definitely suggested and especially fun if it works!

In the next docs we can look at how you can set up Logging with your Config.