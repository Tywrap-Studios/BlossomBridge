# 1.1.1 -> 2.0.0

!!! danger "Breaking changes"
    This update has breaking changes. It is suggested to update and take precautions.
!!! danger "Unstable release"
    This release may be unstable in some situations, if you do end up having problems, report them at the [GitHub issue tracker](https://github.com/Tywrap-Studios/BlossomBridge/issues).  
    We will soon try to release a more stable version if needed.

## Changes:
1. Changed codebase to Kotlin.
2. Made `LoggingHandler.literalDebug()` always ignore config.
3. Made `ConfigManager.loadConfig()` also run `saveConfig()` after validation.
4. Removed `main` package in favor of a very plain `ModInitializer` object.
5. {--AbstractConfigClass--} -> {++BasicConfigClass++} (Renamed)
6. {--net.tywrapstudios.blossombridge--} -> {++org.tywrapstudios.blossombridge++} (Renamed)

## Updating
You don't have to change any of your usage code, but take note of the following:
!!! warning "Package change"
    Due to change 6, you are forced to change your imports.

!!! note "New main config object"
    Due to change 5, you have to implement `BasicConfigClass` instead now.

Newer versions will try to not be as breaking as this one, hence for the choice to change the Major version to `2`.