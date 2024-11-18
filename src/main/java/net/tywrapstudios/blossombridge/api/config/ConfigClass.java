package net.tywrapstudios.blossombridge.api.config;

/**
 * A base interface that should be implemented by every Config class.
 */
public interface ConfigClass {
    /**
     * Validates the config, can be overridden by the implementing class for custom validation logic.
     */
    void validate();
}
