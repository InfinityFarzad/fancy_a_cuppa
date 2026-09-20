package dev.farzad.fancy_a_cuppa.common.block.entity;

import dev.farzad.fancy_a_cuppa.common.init.FACBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MugBlockEntity extends BlockEntity {

    public MugBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(FACBlockEntities.MUG_BLOCK_ENTITY_TYPE, worldPosition, blockState);
    }

}
