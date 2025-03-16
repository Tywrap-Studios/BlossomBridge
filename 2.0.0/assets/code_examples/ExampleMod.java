// -8<- [start:one]
public class ExampleMod implements ModInitializer {
    private static final File CONFIG_DIR = FabricLoader.getInstance().getConfigDir().toFile();
    private static final File FILE = new File(CONFIG_DIR, "validate-example.json5");
    public static final ConfigManager<ValidateExample> CONFIG_MANAGER =
            new ConfigManager<>(ValidateExample.class, FILE);

    @Override
    public void onInitialize() {

    }
}
// -8<- [end:one]
// -8<- [start:two]
    ...
    public static final ConfigManager<ValidateExample> CONFIG_MANAGER =
            new ConfigManager<>(ValidateExample.class, FILE);

    @Override
    public void onInitialize() {
        CONFIG_MANAGER.loadConfig();
    }
}
// -8<- [end:two]
// -8<- [start:three]
    ...
    public static final ConfigManager<ValidateExample> CONFIG_MANAGER =
        new ConfigManager<>(ValidateExample.class, FILE);

    @Override
    public void onInitialize() {
        CONFIG_MANAGER.loadConfig();

        ValidateExample config = CONFIG_MANAGER.getConfig();
        System.out.println("Amount of orbs set: " + config.orbs);
    }
}
// -8<- [end:three]