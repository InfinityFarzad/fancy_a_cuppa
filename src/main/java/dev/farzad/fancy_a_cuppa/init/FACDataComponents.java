package dev.farzad.fancy_a_cuppa.init;

import com.mojang.serialization.Codec;
import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.item.MugItem;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import org.lwjgl.system.ffm.mapping.Mapping;

public interface FACDataComponents {

    DataComponentType<MugItem.ContentType> MUG_CONTENT_TYPE =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    FancyACuppa.id("mug_content_type"),
                    DataComponentType.<MugItem.ContentType>builder().persistent(MugItem.ContentType.CODEC).build()
            );

    DataComponentType<Integer> MUG_LEVEL =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    FancyACuppa.id("mug_level"),
                    DataComponentType.<Integer>builder().persistent(Codec.INT).build()
            );

    static void init () {}
}
