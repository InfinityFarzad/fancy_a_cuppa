package dev.farzad.fancy_a_cuppa.component;

import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.material.Fluid;

public record MugContentComponent(Fluid fluid, PotionContents potionContents) {

}
