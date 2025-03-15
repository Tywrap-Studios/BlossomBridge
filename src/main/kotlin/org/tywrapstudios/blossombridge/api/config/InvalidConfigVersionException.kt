package org.tywrapstudios.blossombridge.api.config

/**
 * Could be thrown when the Config Format version is invalid.
 */
class InvalidConfigVersionException : RuntimeException {
    /**
     * A simple [InvalidConfigFormatException].
     * @param message The Message to display in the StackTrace.
     */
    constructor(message: String?) : super(message)

    /**
     * A simple [InvalidConfigFormatException], but with a `cause`.
     * @param message The Message to display in the StackTrace.
     * @param cause The [Throwable] cause.
     */
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}