package org.tywrapstudios.blossombridge.api.config

import blue.endless.jankson.Comment

/**
 * Base config file that can be extended by a "main" Config class. It has some options required for logging.
 */
abstract class BasicConfigClass : ConfigClass {

    /**
     * Comments work like this, they are allowed as the file is json5 and not plain json.
     */
    @Comment("Several configurations for utility features.")
    var util_config: UtilConfig = UtilConfig()

    /**
     * Nested Config.
     */
    class UtilConfig {
        /**
         * Any type of value that would work in json is allowed here.
         *
         *  E.g. `int, String, List<String>`
         */
        @Comment("Whether to display debug information in the console.")
        var debug_mode: Boolean = false

        @Comment("Whether to suppress all warnings from this mod. NOT RECOMMENDED.")
        var suppress_warns: Boolean = false
    }
}