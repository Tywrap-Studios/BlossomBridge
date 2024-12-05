package net.tywrapstudios.blossombridge.api.logging;

import net.tywrapstudios.blossombridge.api.config.AbstractConfig;
import net.tywrapstudios.blossombridge.api.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A general-purpose Logging Handler compatible with the modular configuration system.
 * This class dynamically fetches configuration values for logging behavior.
 * <p> Note that this should only be used when a Main Config Object (which have to extend {@link AbstractConfig} anyway) object is available.
 * @param <T> The Main Config class of the mod, which is usually already an instance of {@link AbstractConfig}.
 * @author Tiazzz
 */
public class LoggingHandler<T extends AbstractConfig> {
    private final Logger MAIN;
    private final Logger DEBUG;
    private final ConfigManager<T> manager;

    /**
     * Construct a new {@link LoggingHandler}.
     * @param mainLogger A {@link Logger} that logs the main parts of the mod.
     * @param debugLogger A {@link Logger} that logs the debug parts of the mod.
     * @param configManager Your {@link ConfigManager}, this is needed to get various values from your Config.
     */
    public LoggingHandler(Logger mainLogger, Logger debugLogger, ConfigManager<T> configManager) {
        this.MAIN = mainLogger;
        this.DEBUG = debugLogger;
        this.manager = configManager;
    }

    /**
     * Construct a new {@link LoggingHandler}.
     * @param name A {@link String} that represents your mod's name, {@link Logger}{@code s} will automatically be made for you.
     * @param configManager Your {@link ConfigManager}, this is needed to get various values from your Config.
     */
    public LoggingHandler(String name, ConfigManager<T> configManager) {
        this.MAIN = LoggerFactory.getLogger(name + "|Main");
        this.DEBUG = LoggerFactory.getLogger(name + "|Debug");
        this.manager = configManager;
    }

    /**
     * Log a String to the info level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void info(String message) {
        MAIN.info(message);
    }

    /**
     * Log a String to the warn level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void warn(String message) {
        if (!conf().util_config.suppress_warns) {
            MAIN.warn(message);
        }
    }

    /**
     * Log a String to the error level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void error(String message) {
        if (!conf().util_config.suppress_warns) {
            MAIN.error(message);
        }
    }

    /**
     * Log a String to the info and debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    public void debug(String message) {
        if (conf().util_config.debug_mode) {
            DEBUG.info(message);
        }
        literalDebug(message);
    }

    /**
     * Log a String to the debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    public void literalDebug(String message) {
        if (conf().util_config.debug_mode) {
            DEBUG.debug(message);
        }
    }

    /**
     * Alternative version of {@link #literalDebug(String)} that optionally ignores config settings.
     *
     * @param message     The Message String to log.
     * @param ignoreConfig Whether to ignore any Config settings.
     */
    public void literalDebug(String message, boolean ignoreConfig) {
        if (ignoreConfig) {
            DEBUG.debug(message);
        } else {
            literalDebug(message);
        }
    }

    /**
     * Log a String to the warn level of the debug logger.
     * <p>Note that this will also send a literalDebug, which is on the debug level, but it simply has {@code [WARN]} prefixed to it.
     *
     * @param message The Message String to log.
     */
    public void debugWarning(String message) {
        if (conf().util_config.debug_mode && !conf().util_config.suppress_warns) {
            DEBUG.warn(message);
        }
        literalDebug("[WARN] " + message);
    }

    private AbstractConfig conf() {
        return manager.getConfig();
    }
}

