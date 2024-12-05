# BlossomBridge
A small API for Tywrap Studios Mods, that adds a few minor things.

---
Such As:
- A fletched Config system utilizing Jankson and some logic magic.
- A simple, yet niche Logging system, to maintain a consistent log format for all our mods.
- Good JavaDocs, so you can actually properly understand the code.
## Project Setup [![](https://jitpack.io/v/Tywrap-Studios/BlossomBridge.svg)](https://jitpack.io/#Tywrap-Studios/BlossomBridge)
Want to use this API in your mod?  
Feel free to! But keep in mind that a lot of stuff in here is specific to our workflows, so it may not be applicable to your use case.  
Plus, the code is pretty minimal the moment, so it's not really worth it half the time.  
### Gradle Setup
BlossomBridge can easily be depended on like any other Fabric mod.  
Just add the following to your `build.gradle` file:
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    // Other dependencies...
    
	modImplementation("com.github.Tywrap-Studios:BlossomBridge:${project.blossombridge_version}")
}
```
And you add this to your `gradle.properties` file:
```properties
blossombridge_version="1.0.2"
# Or whatever version you want to use :)
```
it is always recommended to use the latest STABLE version, so you don't get any unexpected hiccups of WIP features.  
Last but not least, you need to add the following to your `fabric.mod.json` file:
```json
{
    "depends": {
        "blossombridge": ">=1.0.2"
    }
}
```
## Mod Setup
Once you've added the mod to your project, you can start using it!  
All the code is well documented using JavaDoc, so you should be able to figure out how to use it.  
  
But as a general line of thumb, you do the following: Make a Config class that extends `AbstractConfig`, and then you can make a new `ConfigManager` to load and use it. Alongside that, also construct a `LoggingHandler` and you're good to go!
> [!WARNING]
Do not use the `BlossomBridge` class! Matter of fact, don't use anything from the `main` package!  
ANYTHING IN THE `main` PACKAGE IS NOT PART OF THE API, AND IS INSTEAD FOR THE ACTUAL "MOD" PART OF THE CODE!  
Everything that _is_ api is inside the `api` package (of course)
  
  
As an example, I suggest taking a look at [Tywragriculture](https://github.com/Tywrap-Studios/Tywragriculture), which has a lot of this API's code implemented and used.
