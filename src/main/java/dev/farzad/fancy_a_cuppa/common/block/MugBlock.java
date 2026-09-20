package dev.farzad.fancy_a_cuppa.common.block;

import com.mojang.serialization.MapCodec;
import dev.farzad.fancy_a_cuppa.common.block.entity.MugBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class MugBlock extends BaseEntityBlock {
    public MugBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(MugBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new MugBlockEntity(worldPosition, blockState);
    }
}
