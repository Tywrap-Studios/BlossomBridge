// -8<- [start:one]
public class LoggingExample extends BasicConfigClass {

}
// -8<- [end:one]
// -8<- [start:two]
public class ExampleMod implements ModInitializer {
    private static final File CONFIG_DIR = FabricLoader.getInstance().getConfigDir().toFile();
    private static final File FILE = new File(CONFIG_DIR, "logging-example.json5");
    public static final ConfigManager<LoggingExample> CONFIG_MANAGER =
        new ConfigManager<>(LoggingExample.class, FILE);

    @Override
    public void onInitialize() {
        CONFIG_MANAGER.loadConfig();
    }
}
// -8<- [end:two]
// -8<- [start:three]
    ...
    public static final ConfigManager<LoggingExample> CONFIG_MANAGER =
            new ConfigManager<>(LoggingExample.class, FILE);
    public static final LoggingHandler<LoggingExample> LOGGING =
            new LoggingHandler<>(
                    LoggerFactory.getLogger("ExampleMod|Main"),
                    LoggerFactory.getLogger("ExampleMod|Debug"),
                    CONFIG_MANAGER
            )
    ...
// -8<- [end:three]
// -8<- [start:four]
    ...
    public static final ConfigManager<LoggingExample> CONFIG_MANAGER =
            new ConfigManager<>(LoggingExample.class, FILE);
    public static final LoggingHandler<LoggingExample> LOGGING =
            new LoggingHandler<>("ExampleMod", CONFIG_MANAGER)
            // This will make two Loggers: "ExampleMod|Main" and "ExampleMod|Debug"
    ...
// -8<- [end:four]