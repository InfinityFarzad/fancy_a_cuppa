package dev.farzad.fancy_a_cuppa.client.init;

import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.client.model.item.MugModel;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public interface FACLayerDefinitions {
    ModelLayerLocation MUG = createMain("mug");

    private static ModelLayerLocation createMain(String id) {
        return new ModelLayerLocation(FancyACuppa.id(id), "main");
    }

    static void init() {
        ModelLayerRegistry.registerModelLayer(FACLayerDefinitions.MUG, MugModel::createLayer);
    }
}
