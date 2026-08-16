package dev.farzad.fancy_a_cuppa.init;

import dev.farzad.fancy_a_cuppa.FancyACuppa;
import dev.farzad.fancy_a_cuppa.item.MugItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public interface FACItems {

    Item MUG = register("mug", MugItem::new ,new Item.Properties());

    static Item register(String id, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, FancyACuppa.id(id));
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    static void init() {}
}
