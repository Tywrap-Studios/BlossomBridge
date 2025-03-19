package org.tywrapstudios.blossombridge.api.config;

import blue.endless.jankson.Comment;

/**
 * Base config file that can be extended by a "main" Config class. It has some options required for logging.
 */
public abstract class BasicConfigClass implements ConfigClass {

    /**
     * Comments work like this, they are allowed as the file is json5 and not plain json.
     */
    @Comment("Several configurations for utility features.")
    public UtilConfig util_config = new UtilConfig();

    /**
     * Nested Config.
     */
    public static class UtilConfig {
        /**
         * Any type of value that would work in json is allowed here.
         * E.g. `int, String, List<String>`
         */
        @Comment("Whether to display debug information in the console.")
        public boolean debug_mode = false;

        @Comment("Whether to suppress all warnings from this mod. NOT RECOMMENDED.")
        public boolean suppress_warns = false;
    }
}
