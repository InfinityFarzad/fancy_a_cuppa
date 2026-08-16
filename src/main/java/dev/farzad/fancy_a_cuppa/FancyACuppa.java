package dev.farzad.fancy_a_cuppa;

import dev.farzad.fancy_a_cuppa.init.FACItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FancyACuppa implements ModInitializer {

	public static final String MOD_ID = "fancy_a_cuppa";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Fancy a cuppa?");
		FACItems.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
