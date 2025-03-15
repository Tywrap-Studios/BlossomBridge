package org.tywrapstudios.blossombridge.api.config

/**
 * Could be thrown when the Config file is invalid.
 */
class InvalidConfigFileException : RuntimeException {
    /**
     * A simple [InvalidConfigFileException].
     * @param message The Message to display in the StackTrace.
     */
    constructor(message: String?) : super(message)

    /**
     * A simple [InvalidConfigFileException], but with a `cause`.
     * @param message The Message to display in the StackTrace.
     * @param cause The [Throwable] cause.
     */
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}