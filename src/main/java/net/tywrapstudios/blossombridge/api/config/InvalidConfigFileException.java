package net.tywrapstudios.blossombridge.api.config;

public class InvalidConfigFileException extends RuntimeException {
    public InvalidConfigFileException(String message) {
        super(message);
    }

    public InvalidConfigFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
