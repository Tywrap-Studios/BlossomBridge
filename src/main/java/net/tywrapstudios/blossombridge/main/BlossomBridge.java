package net.tywrapstudios.blossombridge.main;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.blossombridge.api.config.ConfigManager;
import net.tywrapstudios.blossombridge.api.logging.LoggingHandler;
import net.tywrapstudios.blossombridge.main.config.BlossomConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class BlossomBridge implements ModInitializer {
	private static final File CONFIG_FILE =
			new File(FabricLoader.getInstance().getConfigDir().toFile(), "blossombridge.json");
	public static final ConfigManager<BlossomConfig> CONFIG_MANAGER =
			new ConfigManager<>(BlossomConfig.class, CONFIG_FILE);

	private static final Logger MAIN = LoggerFactory.getLogger("BlossomBridge|Main");
	private static final Logger DEBUG = LoggerFactory.getLogger("BlossomBridge|Debug");
	public static LoggingHandler<BlossomConfig> LOGGING;

	@Override
	public void onInitialize() {
		CONFIG_MANAGER.loadConfig();
		LOGGING = new LoggingHandler<>(MAIN, DEBUG, CONFIG_MANAGER.getConfig());

		LOGGING.info("BlossomBridge has been initialized!");
	}
}