package org.tywrapstudios.blossombridge.api.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.tywrapstudios.blossombridge.api.config.BasicConfigClass
import org.tywrapstudios.blossombridge.api.config.ConfigManager

/**
 * A general-purpose Logging Handler compatible with the modular configuration system.
 * This class dynamically fetches configuration values for logging behavior.
 *
 * Note that this should only be used when a Main Config Object (which have to extend [BasicConfigClass] anyway) object is available.
 */
class LoggingHandler<T : BasicConfigClass> {
    private val main: Logger
    private val debug: Logger
    private val manager: ConfigManager<T>

    /**
     * Construct a new [LoggingHandler].
     * @param mainLogger A [Logger] that logs the main parts of the mod.
     * @param debugLogger A [Logger] that logs the debug parts of the mod.
     * @param configManager Your [ConfigManager], this is needed to get various values from your Config.
     */
    constructor(mainLogger: Logger, debugLogger: Logger, configManager: ConfigManager<T>) {
        this.main = mainLogger
        this.debug = debugLogger
        this.manager = configManager
    }

    /**
     * Construct a new [LoggingHandler].
     * @param name A [String] that represents your mod's name, [Logger]`s` will automatically be made for you.
     * @param configManager Your [ConfigManager], this is needed to get various values from your Config.
     */
    constructor(name: String, configManager: ConfigManager<T>) {
        this.main = LoggerFactory.getLogger("$name|Main")
        this.debug = LoggerFactory.getLogger("$name|Debug")
        this.manager = configManager
    }

    /**
     * Log a String to the info level of the main logger.
     *
     * @param message The Message String to log.
     */
    fun info(message: String) {
        main.info(message)
    }

    /**
     * Log a String to the warn level of the main logger.
     *
     * @param message The Message String to log.
     */
    fun warn(message: String) {
        if (!conf().util_config.suppress_warns) {
            main.warn(message)
        }
    }

    /**
     * Log a String to the error level of the main logger.
     *
     * @param message The Message String to log.
     */
    fun error(message: String) {
        if (!conf().util_config.suppress_warns) {
            main.error(message)
        }
    }

    /**
     * Log a String to the info and debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    fun debug(message: String) {
        if (conf().util_config.debug_mode) {
            debug.info(message)
        }
        literalDebug(message)
    }

    /**
     * Log a String to the debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    fun literalDebug(message: String) {
        debug.debug(message)
    }

    /**
     * Log a String to the warn level of the debug logger.
     *
     * @param message The Message String to log.
     */
    fun debugWarning(message: String) {
        if (conf().util_config.debug_mode && !conf().util_config.suppress_warns) {
            debug.warn(message)
        }
    }

    private fun conf(): T {
        return manager.getConfig()!!
    }
}