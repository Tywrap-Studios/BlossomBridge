package org.tywrapstudios.blossombridge

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private object BlossomBridge : ModInitializer {
	private val logger: Logger = LoggerFactory.getLogger("BlossomBridge|Main")

	override fun onInitialize() {
		logger.info("BlossomBridge has been initialized!")
	}
}