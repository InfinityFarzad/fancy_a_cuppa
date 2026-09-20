package dev.farzad.fancy_a_cuppa.common.init;

import com.mojang.serialization.Codec;
import dev.farzad.fancy_a_cuppa.FancyACuppa;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public interface FACDataComponents {

    DataComponentType<Integer> MUG_STAGE =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    FancyACuppa.id("mug_stage"),
                    DataComponentType.<Integer>builder().persistent(Codec.INT).build()
            );

    static void init () {}
}
