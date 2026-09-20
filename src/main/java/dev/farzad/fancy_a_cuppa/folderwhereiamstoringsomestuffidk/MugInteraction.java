package dev.farzad.fancy_a_cuppa.folderwhereiamstoringsomestuffidk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import java.util.Optional;

public record MugInteraction(int stage_addition, int nutrition, float saturation, Optional<Identifier> useResult) {
    public static Codec<MugInteraction> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.INT.fieldOf("stage_addition").forGetter(MugInteraction::stage_addition),
            Codec.INT.fieldOf("nutrition").forGetter(MugInteraction::nutrition),
            Codec.FLOAT.fieldOf("saturation").forGetter(MugInteraction::saturation),
            Identifier.CODEC.optionalFieldOf("useResult").forGetter(MugInteraction::useResult)
    ).apply(i, MugInteraction::new));
}