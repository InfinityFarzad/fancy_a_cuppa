package dev.farzad.fancy_a_cuppa.common.item;

import dev.farzad.fancy_a_cuppa.common.init.FACBlocks;
import dev.farzad.fancy_a_cuppa.common.init.FACDataComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MugItem extends BlockItem {
    public MugItem(Properties properties) {
        super(FACBlocks.MUG, properties.component(FACDataComponents.MUG_STAGE,0));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer().isShiftKeyDown()) {
            InteractionResult placeResult = this.place(new BlockPlaceContext(context));
            if (!placeResult.consumesAction() && context.getItemInHand().has(DataComponents.CONSUMABLE)) {
                return super.use(context.getLevel(), context.getPlayer(), context.getHand());
            }
            return placeResult;
        }
        return InteractionResult.PASS;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.DRINK;
    }

    public void onConsume(ItemStack stack, Player player) {
        int stage = Math.clamp(stack.getOrDefault(FACDataComponents.MUG_STAGE,0),0,3);
        stack.set(FACDataComponents.MUG_STAGE,Math.min(stage + 1 ,3));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return super.use(level, player, hand);
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity user) {
        return 12;
    }
}
