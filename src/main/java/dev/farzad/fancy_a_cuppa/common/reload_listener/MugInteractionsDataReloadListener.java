package dev.farzad.fancy_a_cuppa.common.reload_listener;

import com.mojang.serialization.JsonOps;
import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.folderwhereiamstoringsomestuffidk.MugInteraction;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import java.util.HashMap;

public class MugInteractionsDataReloadListener extends SimpleReloadListener<HashMap<Identifier, MugInteraction>> {

    @Override
    protected HashMap<Identifier, MugInteraction> prepare(SharedState state) {
        HashMap<Identifier, MugInteraction> baseData = new HashMap<>();
        SimpleJsonResourceReloadListener.scanDirectory(state.resourceManager(), FileToIdConverter.json("mug_interaction"), JsonOps.INSTANCE, MugInteraction.CODEC, baseData);

        return baseData;
    }

    @Override
    protected void apply(HashMap<Identifier, MugInteraction> prepared, SharedState state) {
        FancyACuppa.MUG_DATA.clear();
        FancyACuppa.MUG_DATA = prepared;
        FancyACuppa.LOGGER.info("loaded " + prepared.size() + " mug interactions");
    }
}
