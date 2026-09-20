package dev.farzad.fancy_a_cuppa;

import dev.farzad.fancy_a_cuppa.common.init.FACBlockEntities;
import dev.farzad.fancy_a_cuppa.common.init.FACBlocks;
import dev.farzad.fancy_a_cuppa.common.init.FACDataComponents;
import dev.farzad.fancy_a_cuppa.common.init.FACItems;
import dev.farzad.fancy_a_cuppa.folderwhereiamstoringsomestuffidk.MugInteraction;
import dev.farzad.fancy_a_cuppa.common.reload_listener.MugInteractionsDataReloadListener;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.resources.Identifier;

import net.minecraft.server.packs.PackType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class FancyACuppa implements ModInitializer {

	public static final String MOD_ID = "fancy_a_cuppa";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static HashMap<Identifier, MugInteraction> MUG_DATA = new HashMap<>();

	@Override
	public void onInitialize() {
		LOGGER.info("Fancy a cuppa?");

		FACItems.init();
		FACBlocks.init();
		FACBlockEntities.init();
		FACDataComponents.init();
		ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(id("mug_interaction_listener"),new MugInteractionsDataReloadListener());

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
