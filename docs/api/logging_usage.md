---
tags:
  - Developer Guides
  - Logging Module
---
# Using a LoggingHandler

!!! example "All usages"
    A `LoggingHandler` has a lot of options to log messages with, to view them all, you're better off looking at the comments in the following code block:  
    Note that it is written in {==Kotlin :simple-kotlin:==}!
    ??? abstract "LoggingHandler.kt"
        ```kotlin title="LoggingHandler.kt",linenums="1"
        -8<- "src/main/kotlin/org/tywrapstudios/blossombridge/api/logging/LoggingHandler.kt"
        ```

Apart from this, using a `LoggingHandler` is not hard at all. Just call the respective methods for the log levels and whatnot.

A few notes though:

!!! note "Config"
    The entire reason you need to extend `BasicConfigClass` is so there are debug and warn suppression options available that match up with calling methods in the class.

!!! note "Debug"
    `LoggingHandler.debug(message: String)` will call your message on the INFO level of the debug `Logger`, this counts for some other debug methods too.

!!! note "Literal Debug"
    While `.debug(message: String)` sends to the INFO level of the debug `Logger`, `.literalDebug(message: String)` sends to its DEBUG level.
    It also fully ignores config settings, meaning it can be safely run before mod initialisation without having to worry about your config not having read yet.