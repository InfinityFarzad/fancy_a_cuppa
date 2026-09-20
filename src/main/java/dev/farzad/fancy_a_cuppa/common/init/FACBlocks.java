package dev.farzad.fancy_a_cuppa.common.init;

import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.common.block.MugBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public interface FACBlocks {

    Block MUG = register("mug", i -> new MugBlock(i), BlockBehaviour.Properties.of());

    static Block register(String id, Function<BlockBehaviour.Properties, Block> blockFunction, BlockBehaviour.Properties behaviour) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, FancyACuppa.id(id));
        Block block = blockFunction.apply(behaviour.setId(blockKey));
        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        return block;
    }

    static void init() {}
}
