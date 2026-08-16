package dev.farzad.fancy_a_cuppa.client;

import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.client.init.FACLayerDefinitions;
import dev.farzad.fancy_a_cuppa.client.render.special.MugSpecialRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.special.SpecialModelRenderers;

public class FancyACuppaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FACLayerDefinitions.init();
        SpecialModelRenderers.ID_MAPPER.put(FancyACuppa.id("mug"), MugSpecialRenderer.Unbaked.MAP_CODEC);
    }
}
