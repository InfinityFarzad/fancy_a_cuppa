package dev.farzad.fancy_a_cuppa.client.render.special;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import dev.farzad.fancy_a_cuppa.client.init.FACLayerDefinitions;
import dev.farzad.fancy_a_cuppa.client.model.item.MugModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.model.object.projectile.TridentModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.ShieldSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class MugSpecialRenderer implements SpecialModelRenderer<DataComponentMap> {

    private MugModel model;

    public MugSpecialRenderer(MugModel model) {
        this.model = model;
    }

    @Override
    public void submit(@Nullable DataComponentMap argument, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, boolean hasFoil, int outlineColor) {
        poseStack.pushPose();
        submitNodeCollector.submitModelPart(this.model.root(), poseStack, this.model.renderType(MugModel.TEXTURE), lightCoords, overlayCoords, null, false, hasFoil, -1, null, outlineColor);
        //submitNodeCollector.submitModelPart(this.model.root(), poseStack, this.model.renderType(), lightCoords, overlayCoords, null, false, hasFoil, -1, null, outlineColor);
        poseStack.popPose();
    }

    @Override
    public void getExtents(Consumer<Vector3fc> output) {
        this.model.root().getExtentsForGui(new PoseStack(),output);
    }

    @Override
    public @Nullable DataComponentMap extractArgument(ItemStack stack) {
        return stack.immutableComponents();
    }

    @Environment(value= EnvType.CLIENT)
    public record Unbaked() implements SpecialModelRenderer.Unbaked<DataComponentMap>
    {
        public static final MugSpecialRenderer.Unbaked INSTANCE = new MugSpecialRenderer.Unbaked();
        public static final MapCodec<MugSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(INSTANCE);

        @Override
        public MapCodec<MugSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        public MugSpecialRenderer bake(SpecialModelRenderer.BakingContext context) {
            return new MugSpecialRenderer(new MugModel(context.entityModelSet().bakeLayer(FACLayerDefinitions.MUG)));
        }
    }
}
