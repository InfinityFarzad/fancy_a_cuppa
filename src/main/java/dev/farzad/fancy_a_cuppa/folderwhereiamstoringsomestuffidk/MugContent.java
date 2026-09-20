package dev.farzad.fancy_a_cuppa.folderwhereiamstoringsomestuffidk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;

public record MugContent(int stage, int nutrition, float saturation, List<MobEffectInstance> effects) {
    public static Codec<MugContent> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.INT.fieldOf("stage").forGetter(MugContent::stage),
            Codec.INT.fieldOf("nutrition").forGetter(MugContent::nutrition),
            Codec.FLOAT.fieldOf("saturation").forGetter(MugContent::saturation),
            MobEffectInstance.CODEC.listOf().fieldOf("effects").forGetter(MugContent::effects)
    ).apply(i, MugContent::new));
}
