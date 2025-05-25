package org.tywrapstudios.blossombridge.api.config

import blue.endless.jankson.Jankson
import blue.endless.jankson.JsonGrammar
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileWriter
import java.io.IOException

/**
 * A helper class that can manage a [ConfigClass].
 * @param configClass The [ConfigClass] that the [ConfigManager] will manage.
 * @param configFile The [File] that the [ConfigManager] will use to save and load the configuration. Note that this currently has to be a JSON5 file.
 */
class ConfigManager<T : ConfigClass>(configClass: Class<T>, configFile: File) {
    private val classLogger: Logger = LoggerFactory.getLogger(ConfigManager::class.java)
    private val jankson: Jankson
    private val configClass: Class<T>
    private val configFile: File
    private lateinit var config: T

    init {
        val finalConfigFile: File
        this.jankson = Jankson.builder().build()
        this.configClass = configClass
        classLogger.debug("Checking file extension of {}", configFile.name)
        if (!configFile.name.endsWith(".json5")) {
            throw InvalidConfigFileException("Config file must have a .json5 extension: " + configFile.name)
        } else {
            finalConfigFile = configFile
        }
        this.configFile = finalConfigFile
    }

    /**
     * Loads the configuration from a file. If the file does not exist, creates a default config.
     */
    fun loadConfig() {
        try {
            if (!configFile.exists()) {
                // Create a default configuration if the file doesn't exist
                classLogger.debug("Creating new config file for class: {}", configClass.name)
                this.config = configClass.getDeclaredConstructor().newInstance()
                this.saveConfig()
                return
            }

            // Read the file and deserialize
            try {
                this.config = jankson.fromJson(
                    jankson.load(configFile),
                    configClass
                )

                this.config.validate()
                this.saveConfig()
            } catch (e: Exception) {
                throw InvalidConfigFileException("Invalid config file: $configFile.name", e)
            }
        } catch (e: Exception) {
            classLogger.error("Something went wrong while loading config file: $configFile.name", e)
            e.printStackTrace()
        }
    }

    /**
     * Saves the current configuration instance to the file.
     */
    fun saveConfig() {
        try {
            FileWriter(configFile).use { writer ->
                val json: String = jankson.toJson(config).toJson(JsonGrammar.JANKSON)
                writer.write(json)
                classLogger.debug("Saved to config file: {}.name", configFile)
            }
        } catch (e: IOException) {
            classLogger.error("Something went wrong while saving config file: $configFile.name")
            e.printStackTrace()
        }
    }

    /**
     * Returns the configuration file as a JSON string.
     * @param comments Whether to include comments in the JSON string.
     * @param newlines Whether to include newlines in the JSON string.
     * @return The configuration file as a JSON string.
     */
    fun getConfigJsonAsString(comments: Boolean, newlines: Boolean): String {
        return jankson.toJson(this.config).toJson(comments, newlines).replace("\t", "  ")
    }

    /**
     * Returns the current config state.
     * @return The config.
     */
    fun getConfig(): T {
        return this.config
    }
}